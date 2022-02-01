package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.forward.ForwardOrderManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.receipt.ReceiptMsgManager;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout1;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout2;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout29;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayoutDefault;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.structmsg.view.StructMsgItemType;
import com.tencent.mobileqq.structmsg.widget.HeightLimitedLinearLayout;
import com.tencent.mobileqq.transfile.ForwardSdkShareProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.ArkMessageBuilder;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class AbsShareMsg
  extends AbsStructMsg
  implements Iterable<AbsStructMsgElement>
{
  public static final int PACKAGE_NAME_INDEX = 0;
  public static final int URL_DATA_INDEX = 1;
  public int forwardType;
  public String mAdSourceIcon = null;
  public String mAdSourceMenu = null;
  public String mAdSourceName = null;
  public String mContentCover = null;
  public int mContentLayout = -1;
  public String mContentSrc = null;
  public String mContentSummary = null;
  public String mContentTitle = null;
  JSONObject mDatas = null;
  public boolean mHasAdSource;
  boolean mHasSource;
  public boolean mMsgException = false;
  public String mSourceAction = null;
  public String mSourceActionData = null;
  public long mSourceAppid = -1L;
  public String mSourceIcon = null;
  public String mSourceName = null;
  protected View.OnClickListener mSourceOnClickListener = new AbsShareMsg.1(this);
  public String mSourceUrl = null;
  public String mSource_A_ActionData = null;
  public String mSource_I_ActionData = null;
  public List<AbsStructMsgElement> mStructMsgItemLists = new ArrayList();
  public AbsShareMsg.ShareData shareData = new AbsShareMsg.ShareData();
  
  AbsShareMsg()
  {
    this.mVersion = 28;
  }
  
  AbsShareMsg(Bundle paramBundle)
  {
    super(paramBundle);
    this.mVersion = 28;
    this.mContentCover = paramBundle.getString("image_url_remote");
    if (this.mContentCover != null)
    {
      this.shareData.imageUrlStatus = paramBundle.getByte("struct_share_key_image_url_status", (byte)4).byteValue();
      this.mContentTitle = paramBundle.getString("title");
      this.mContentSummary = paramBundle.getString("desc");
      if (this.mContentTitle != null) {
        this.mContentTitle = MessageUtils.a(this.mContentTitle, false);
      }
      if (this.mContentSummary != null) {
        this.mContentSummary = MessageUtils.a(this.mContentSummary, false);
      }
      this.mMsgAction = paramBundle.getString("struct_share_key_content_action");
      this.mMsgActionData = paramBundle.getString("struct_share_key_content_action_DATA");
      this.mMsg_A_ActionData = paramBundle.getString("struct_share_key_content_a_action_DATA");
      this.mMsg_I_ActionData = paramBundle.getString("struct_share_key_content_i_action_DATA");
      this.mSourceAppid = paramBundle.getLong("req_share_id", -1L);
      this.mSourceUrl = paramBundle.getString("struct_share_key_source_url");
      this.mSourceAction = paramBundle.getString("struct_share_key_source_action");
      if (TextUtils.isEmpty(this.mSourceAction)) {
        this.mSourceAction = "app";
      }
      this.mSourceActionData = paramBundle.getString("struct_share_key_source_action_data");
      this.mSource_A_ActionData = paramBundle.getString("struct_share_key_source_a_action_data");
      this.mSource_I_ActionData = paramBundle.getString("struct_share_key_source_i_action_data");
      if ((TextUtils.isEmpty(this.mSource_I_ActionData)) && (this.mSourceAppid > 0L) && (!"plugin".equals(this.mSourceAction))) {
        this.mSource_I_ActionData = String.format("tencent%d://", new Object[] { Long.valueOf(this.mSourceAppid) });
      }
      this.mSourceIcon = paramBundle.getString("struct_share_key_source_icon");
      this.mSourceName = paramBundle.getString("struct_share_key_source_name");
      this.forwardType = paramBundle.getInt("forward_type");
      if ((this.forwardType != 11) && (TextUtils.isEmpty(this.mSourceName))) {
        this.mSourceName = paramBundle.getString("app_name");
      }
      this.mMsgBrief = paramBundle.getString("brief_key");
      if (TextUtils.isEmpty(this.mMsgBrief))
      {
        if (TextUtils.isEmpty(this.mSourceName)) {
          break label1095;
        }
        this.mMsgBrief = String.format(ap, new Object[] { this.mSourceName });
      }
      label512:
      this.mResid = paramBundle.getString("mm_resid");
      this.mFileName = paramBundle.getString("mm_file_name");
      this.mFileSize = paramBundle.getLong("mm_file_size");
      this.mCompatibleText = paramBundle.getString("compatible_text");
      this.fwFlag = paramBundle.getInt("is_share_flag", 0);
      if ((!this.mHasSource) && ((!TextUtils.isEmpty(this.mSourceName)) || (!TextUtils.isEmpty(this.mSourceIcon)))) {
        this.mHasSource = true;
      }
      if ((TextUtils.isEmpty(this.mContentTitle)) && (TextUtils.isEmpty(this.mContentSummary))) {
        if (!TextUtils.isEmpty(this.mSourceName)) {
          break label1105;
        }
      }
    }
    label1095:
    label1105:
    for (this.mContentTitle = ao;; this.mContentTitle = String.format(an, new Object[] { this.mSourceName }))
    {
      this.mNeedRound = paramBundle.getString("icon_need_round");
      this.mFlag = paramBundle.getInt("flag");
      this.shareData.appInfoStatus = paramBundle.getByte("struct_share_key_app_info_status", (byte)0).byteValue();
      this.shareData.sourceIconBig = paramBundle.getString("struct_share_key_source_icon_big");
      this.shareData.pkgName = paramBundle.getString("pkg_name");
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, new StringBuilder().append("msgUrl = ").append(this.mMsgUrl).toString() + new StringBuilder().append(", mVersion = ").append(this.mVersion).toString() + ", mContentCover = " + this.mContentCover + ", mContentTitle = " + this.mContentTitle + ", mContentSummary = " + this.mContentSummary + ", mMsgAction = " + this.mMsgAction + ", mMsgActionData = " + this.mMsgActionData + ", mMsg_A_ActionData = " + this.mMsg_A_ActionData + ", mMsg_I_ActionData = " + this.mMsg_I_ActionData + ", mSourceAppid = " + this.mSourceAppid + ", mSourceUrl = " + this.mSourceUrl + ", mSourceAction = " + this.mSourceAction + ", mSourceActionData = " + this.mSourceActionData + ", mSource_A_ActionData = " + this.mSource_A_ActionData + ", mSource_I_ActionData = " + this.mSource_I_ActionData + ", mSourceIcon = " + this.mSourceIcon + ", mSourceName = " + this.mSourceName + ", mMsgBrief = " + this.mMsgBrief + ", mResid = " + this.mResid + ", mFileName = " + this.mFileName + ", mFileSize = " + this.mFileSize + ", mCompatibleText = " + this.mCompatibleText + ", fwFlag = " + this.fwFlag + ", mHasSource = " + this.mHasSource + ", mSType = " + this.mSType);
      }
      return;
      this.mContentCover = paramBundle.getString("image_url");
      this.shareData.imageUrlStatus = 2;
      break;
      this.mMsgBrief = DEFAULT_MSG_BRIEF;
      break label512;
    }
  }
  
  AbsShareMsg(StructMsgNode paramStructMsgNode)
  {
    super(paramStructMsgNode);
    this.mVersion = 28;
    int m = paramStructMsgNode.a();
    int i = 0;
    if (i < m)
    {
      StructMsgNode localStructMsgNode = paramStructMsgNode.a(i);
      int k;
      if (localStructMsgNode == null) {
        k = j;
      }
      for (;;)
      {
        i += 1;
        j = k;
        break;
        if (localStructMsgNode.b.equals("source"))
        {
          parseSourceNode(localStructMsgNode);
          k = j;
          if (j != 0)
          {
            parseDefaultContentNode();
            k = j;
          }
        }
        else if (localStructMsgNode.b.equals("sourceAd"))
        {
          parseAdSourceNode(localStructMsgNode);
          k = j;
          if (j != 0)
          {
            parseDefaultContentNode();
            k = j;
          }
        }
        else if ((this.mMsgServiceID == 128) && (localStructMsgNode.b.equals("data")))
        {
          parseDataNode(localStructMsgNode);
          k = j;
        }
        else
        {
          k = j;
          if (j == 0)
          {
            k = j;
            if (!parseContentNode(localStructMsgNode))
            {
              this.mStructMsgItemLists.clear();
              k = 1;
            }
          }
        }
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, TransferRequest paramTransferRequest)
  {
    ((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync(paramTransferRequest);
  }
  
  private boolean a()
  {
    if (!TextUtils.isEmpty(this.mSourceAction)) {
      return false;
    }
    if ((this.mStructMsgItemLists == null) || (this.mStructMsgItemLists.isEmpty())) {
      return false;
    }
    Object localObject = (AbsStructMsgElement)this.mStructMsgItemLists.get(0);
    if (!(localObject instanceof StructMsgItemLayoutDefault)) {
      return false;
    }
    localObject = (StructMsgItemLayoutDefault)localObject;
    if ((((StructMsgItemLayoutDefault)localObject).a == null) || (((StructMsgItemLayoutDefault)localObject).a.isEmpty())) {
      return false;
    }
    localObject = (AbsStructMsgElement)((StructMsgItemLayoutDefault)localObject).a.get(0);
    if (!(localObject instanceof StructMsgItemImage)) {
      return false;
    }
    return ((StructMsgItemImage)localObject).a();
  }
  
  public static final void doReport(QQAppInterface paramQQAppInterface, AbsShareMsg paramAbsShareMsg)
  {
    StatisticCollector.getInstance(BaseApplication.getContext()).reportActionCount(paramQQAppInterface, paramAbsShareMsg.uin, "Structured_msg", "Clk_smsg", 0, 1, null, String.valueOf(paramAbsShareMsg.mSourceAppid), String.valueOf(paramAbsShareMsg.mMsgServiceID), paramAbsShareMsg.mMsgAction, null);
    if (QLog.isColorLevel()) {
      QLog.d("StructMsg", 2, "doReport msg:" + paramAbsShareMsg);
    }
  }
  
  public static final String[] parsePackageNameAndData(String paramString1, String paramString2)
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "";
    arrayOfString[1] = "";
    if (TextUtils.isEmpty(paramString2)) {
      if (!TextUtils.isEmpty(paramString1)) {
        break label49;
      }
    }
    label49:
    for (int i = -1;; i = paramString1.indexOf("://"))
    {
      if (i != -1) {
        break label60;
      }
      arrayOfString[0] = paramString1;
      return arrayOfString;
      paramString1 = paramString2;
      break;
    }
    label60:
    arrayOfString[0] = paramString1.substring(0, i);
    arrayOfString[1] = paramString1.substring(i + 3);
    return arrayOfString;
  }
  
  public static void resendSdkFakeMessage(MessageForArkApp paramMessageForArkApp, JSONObject paramJSONObject, UpCallBack paramUpCallBack)
  {
    paramMessageForArkApp = ForwardSdkShareProcessor.buildTransferRequest(paramMessageForArkApp, paramJSONObject, paramUpCallBack);
    a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramMessageForArkApp);
  }
  
  public static void resendSdkShareMessage(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, AbsShareMsg paramAbsShareMsg)
  {
    paramMessageRecord = MessageRecordFactory.a(paramMessageRecord);
    ForwardOrderManager.a().a(paramMessageRecord.uniseq, paramAbsShareMsg.parentUniseq, paramAbsShareMsg.forwardID);
    paramQQAppInterface.getMessageFacade().a(paramMessageRecord, MessageCache.a);
    paramMessageRecord = ForwardSdkShareProcessor.buildTransferRequestFromMessage(paramMessageRecord, paramAbsShareMsg);
    ((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync(paramMessageRecord);
  }
  
  public static MessageForArkApp sendSdkFakeMessage(Bundle paramBundle, QQAppInterface paramQQAppInterface, AbsShareMsg paramAbsShareMsg, String paramString1, int paramInt, String paramString2, UpCallBack paramUpCallBack)
  {
    paramBundle = ArkMessageBuilder.a(paramBundle, paramQQAppInterface, paramString1, paramInt, paramString2);
    ForwardOrderManager.a().a(paramBundle.uniseq, paramAbsShareMsg.parentUniseq, paramAbsShareMsg.forwardID);
    paramQQAppInterface.getMessageFacade().a(paramBundle, MessageCache.a);
    a(paramQQAppInterface, ForwardSdkShareProcessor.buildTransferRequestFromMessageExtra(paramBundle, paramAbsShareMsg, paramUpCallBack));
    QLog.d("StructMsg", 1, new Object[] { "sendSdkFakeMessage uinType=", Integer.valueOf(paramInt), ", groupUin=", paramString2 });
    return paramBundle;
  }
  
  public static void sendSdkShareMessage(QQAppInterface paramQQAppInterface, AbsShareMsg paramAbsShareMsg, String paramString1, int paramInt, String paramString2)
  {
    int i = MobileQQService.seq;
    MobileQQService.seq = i + 1;
    long l = i;
    String str = paramQQAppInterface.getCurrentAccountUin();
    if (TextUtils.isEmpty(paramString2)) {
      paramString2 = str;
    }
    for (;;)
    {
      paramString1 = MessageRecordFactory.a(paramQQAppInterface, str, paramString1, paramString2, paramInt, l, paramAbsShareMsg);
      ForwardOrderManager.a().a(paramString1.uniseq, paramAbsShareMsg.parentUniseq, paramAbsShareMsg.forwardID);
      paramQQAppInterface.getMessageFacade().a(paramString1, MessageHandler.e);
      paramAbsShareMsg = ForwardSdkShareProcessor.buildTransferRequestFromMessage(paramString1, paramAbsShareMsg);
      ((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync(paramAbsShareMsg);
      return;
    }
  }
  
  public static void sendSdkShareMessageByServer(QQAppInterface paramQQAppInterface, AbsShareMsg paramAbsShareMsg, String paramString1, int paramInt, String paramString2, UpCallBack paramUpCallBack)
  {
    int i = MobileQQService.seq;
    MobileQQService.seq = i + 1;
    long l = i;
    String str = paramQQAppInterface.getCurrentAccountUin();
    if (TextUtils.isEmpty(paramString2)) {
      paramString2 = str;
    }
    for (;;)
    {
      paramString1 = MessageRecordFactory.a(paramQQAppInterface, str, paramString1, paramString2, paramInt, l, paramAbsShareMsg);
      ForwardOrderManager.a().a(paramString1.uniseq, paramAbsShareMsg.parentUniseq, paramAbsShareMsg.forwardID);
      a(paramQQAppInterface, ForwardSdkShareProcessor.buildTransferRequestFromMessageExtra(paramString1, paramAbsShareMsg, paramUpCallBack));
      QLog.d("StructMsg", 1, "sendSdkShareMessageByServer");
      return;
    }
  }
  
  public void addItem(AbsStructMsgElement paramAbsStructMsgElement)
  {
    this.mStructMsgItemLists.add(paramAbsStructMsgElement);
  }
  
  public void addItems(List<AbsStructMsgElement> paramList)
  {
    this.mStructMsgItemLists.addAll(paramList);
  }
  
  public void clearItems()
  {
    this.mStructMsgItemLists.clear();
  }
  
  public AbsStructMsgElement findXmlNode(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    int j = getItemCount();
    int i = 0;
    if (i < j)
    {
      Object localObject = getItemByIndex(i);
      if (localObject == null) {
        label32:
        break label61;
      }
      label61:
      label98:
      do
      {
        do
        {
          i += 1;
          break;
          if (!(localObject instanceof AbsStructMsgItem)) {
            break label98;
          }
          localObject = ((AbsStructMsgItem)localObject).a.iterator();
        } while (!((Iterator)localObject).hasNext());
        AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)((Iterator)localObject).next();
        if (!paramString.equals(localAbsStructMsgElement.a)) {
          break label32;
        }
        return localAbsStructMsgElement;
      } while (!paramString.equals(((AbsStructMsgElement)localObject).a));
      return localObject;
    }
    return null;
  }
  
  public byte[] getBytes()
  {
    try
    {
      Object localObject = new ByteArrayOutputStream();
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream((OutputStream)localObject);
      writeExternal(localObjectOutputStream);
      localObjectOutputStream.flush();
      localObjectOutputStream.close();
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      return localObject;
    }
    catch (IOException localIOException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, localIOException.getMessage());
      }
    }
    return null;
  }
  
  public AbsStructMsgElement getItemByIndex(int paramInt)
  {
    return (AbsStructMsgElement)this.mStructMsgItemLists.get(paramInt);
  }
  
  public int getItemCount()
  {
    return this.mStructMsgItemLists.size();
  }
  
  public abstract View.OnClickListener getOnClickListener();
  
  public View getPreDialogView(Context paramContext, View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[@]", 2, "AbsShareMsg getPreDialogView start!");
    }
    HeightLimitedLinearLayout localHeightLimitedLinearLayout = new HeightLimitedLinearLayout(paramContext);
    Object localObject1 = new LinearLayout.LayoutParams(-1, -2);
    localHeightLimitedLinearLayout.setOrientation(1);
    try
    {
      localHeightLimitedLinearLayout.setMaxHeight(paramContext.getResources().getDisplayMetrics().heightPixels >> 1);
      ((LinearLayout.LayoutParams)localObject1).gravity = 1;
      localHeightLimitedLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putBoolean("pre_dialog", true);
      Iterator localIterator = this.mStructMsgItemLists.iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label310;
        }
        Object localObject2 = (AbsStructMsgElement)localIterator.next();
        View localView = ((AbsStructMsgElement)localObject2).a(paramContext, paramView, (Bundle)localObject1);
        if ((localView != null) && ((!(localObject2 instanceof StructMsgItemLayoutDefault)) || (((StructMsgItemLayoutDefault)localObject2).o != 1)))
        {
          if ((localObject2 instanceof StructMsgItemLayout2))
          {
            localTextView = (TextView)localView.findViewById(2131380651);
            if (localTextView != null)
            {
              localObject2 = (StructMsgItemLayout2)localObject2;
              if ((((StructMsgItemLayout2)localObject2).o != 1) && (((StructMsgItemLayout2)localObject2).o != 3)) {
                break;
              }
              localTextView.setTextColor(-8355712);
            }
          }
          localHeightLimitedLinearLayout.addView(localView);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        TextView localTextView;
        if (QLog.isColorLevel())
        {
          QLog.d("StructMsg", 2, "shareMsg preDialogView setMaxHeight error!");
          continue;
          localTextView.setGravity(16);
          localTextView.setMaxLines(2);
          localTextView.setTextSize(14.0F);
          localTextView.setTextColor(paramContext.getResources().getColor(2131165676));
          if (TextUtils.isEmpty(localTextView.getText()))
          {
            localTextView.setText("");
            localTextView.setVisibility(0);
          }
        }
      }
      label310:
      if (QLog.isColorLevel()) {
        QLog.d("[@]", 2, "AbsShareMsg getPreDialogView end!");
      }
    }
    return localHeightLimitedLinearLayout;
  }
  
  public String getSourceName()
  {
    return this.mSourceName;
  }
  
  public View getSourceView(Context paramContext, View paramView)
  {
    boolean bool = this.mHasSource;
    if (this.mMsgServiceID == 35) {
      bool = false;
    }
    if (!bool) {
      return null;
    }
    Resources localResources = paramContext.getResources();
    if (paramView == null)
    {
      paramView = new TextView(paramContext);
      paramView.setSingleLine(true);
      paramView.setGravity(16);
      paramView.setEllipsize(TextUtils.TruncateAt.END);
      paramView.setTextColor(-1);
      paramView.setTextSize(2, 12.0F);
    }
    for (;;)
    {
      TextView localTextView = (TextView)paramView;
      localTextView.setText(this.mSourceName);
      localTextView.setBackgroundResource(2130842803);
      Drawable localDrawable1;
      if (!TextUtils.isEmpty(this.mSourceIcon))
      {
        Object localObject = this.mSourceIcon;
        Drawable localDrawable2 = localResources.getDrawable(2130850896);
        localDrawable2.setBounds(0, 0, AIOUtils.a(12.0F, localResources), AIOUtils.a(12.0F, localResources));
        localDrawable1 = localResources.getDrawable(2130850897);
        localDrawable1.setBounds(0, 0, AIOUtils.a(12.0F, localResources), AIOUtils.a(12.0F, localResources));
        try
        {
          localObject = URLDrawable.getDrawable((String)localObject, localDrawable2, localDrawable1);
          if (URLDrawableHelper.isMobileNetAndAutodownDisabled(paramContext)) {
            break label278;
          }
          bool = true;
          ((URLDrawable)localObject).setAutoDownload(bool);
          paramContext = (Context)localObject;
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            QLog.e("StructMsg", 1, paramContext.getMessage(), paramContext);
            paramContext = localDrawable1;
          }
        }
        setCompoundDrawable(localTextView, paramContext, localResources);
      }
      for (;;)
      {
        localTextView.setPadding(AIOUtils.a(5.0F, localResources), 0, AIOUtils.a(5.0F, localResources), 0);
        paramView.setTag(this);
        paramView.setOnClickListener(this.mSourceOnClickListener);
        if (!a()) {
          break label314;
        }
        paramView.setClickable(false);
        QLog.d("StructMsg", 1, "mSourceOnClickListener =========forbidClickForImageShare ========= ");
        return paramView;
        label278:
        bool = false;
        break;
        localTextView.setCompoundDrawables(null, null, null, null);
      }
      label314:
      paramView.setClickable(true);
      return paramView;
    }
  }
  
  public List<AbsStructMsgElement> getStructMsgItemLists()
  {
    return this.mStructMsgItemLists;
  }
  
  public String getTalkBackStr()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    AbsStructMsgElement localAbsStructMsgElement;
    label118:
    do
    {
      for (;;)
      {
        try
        {
          if (this.mStructMsgItemLists != null)
          {
            Iterator localIterator = this.mStructMsgItemLists.iterator();
            if (localIterator.hasNext())
            {
              localObject = (AbsStructMsgElement)localIterator.next();
              if (!(localObject instanceof StructMsgItemLayout1)) {
                break label118;
              }
              localObject = ((StructMsgItemLayout1)localObject).a.iterator();
              if (((Iterator)localObject).hasNext())
              {
                localAbsStructMsgElement = (AbsStructMsgElement)((Iterator)localObject).next();
                if (!(localAbsStructMsgElement instanceof StructMsgItemTitle)) {
                  continue;
                }
                localStringBuffer.append(((StructMsgItemTitle)localAbsStructMsgElement).ai);
                continue;
              }
              continue;
            }
          }
          return localStringBuffer.toString();
        }
        catch (Exception localException) {}
        if (!(localObject instanceof StructMsgItemLayout2)) {
          break;
        }
        localObject = (StructMsgItemLayout2)localObject;
        localStringBuffer.append("链接");
        localObject = ((StructMsgItemLayout2)localObject).a.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localAbsStructMsgElement = (AbsStructMsgElement)((Iterator)localObject).next();
          if ((localAbsStructMsgElement instanceof StructMsgItemTitle)) {
            localStringBuffer.append(((StructMsgItemTitle)localAbsStructMsgElement).ai);
          } else if ((localAbsStructMsgElement instanceof StructMsgItemSummary)) {
            localStringBuffer.append(((StructMsgItemSummary)localAbsStructMsgElement).ai);
          }
        }
      }
    } while (!(localObject instanceof StructMsgItemLayout29));
    Object localObject = (StructMsgItemLayout29)localObject;
    int i = 0;
    localObject = ((StructMsgItemLayout29)localObject).a.iterator();
    label248:
    if (((Iterator)localObject).hasNext())
    {
      localAbsStructMsgElement = (AbsStructMsgElement)((Iterator)localObject).next();
      if (("type".equals(localAbsStructMsgElement.a)) && ((localAbsStructMsgElement instanceof StructMsgItemType))) {
        i = ((StructMsgItemType)localAbsStructMsgElement).o;
      }
    }
    for (;;)
    {
      localStringBuffer.append("文本");
      for (;;)
      {
        localStringBuffer.append("回执消息");
        if (!this.message.isSend()) {
          break label363;
        }
        localStringBuffer.append(",查看阅读状态");
        break;
        localStringBuffer.append("图片");
        continue;
        localStringBuffer.append("语音");
      }
      label363:
      if ("1".equals(ReceiptMsgManager.a(this.message)))
      {
        localStringBuffer.append(",已读");
        break;
      }
      localStringBuffer.append(",未读");
      break;
      break label248;
      switch (i)
      {
      }
    }
  }
  
  public boolean isSdkShareMsg()
  {
    return ForwardUtils.a(this.forwardType, this.mMsgServiceID);
  }
  
  public Iterator<AbsStructMsgElement> iterator()
  {
    return this.mStructMsgItemLists.iterator();
  }
  
  protected void parseAdSourceNode(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {}
    do
    {
      JSONObject localJSONObject1;
      for (;;)
      {
        return;
        this.mAdSourceName = paramStructMsgNode.a("name");
        if (!this.mAdSourceName.equals("")) {
          this.mHasAdSource = true;
        }
        try
        {
          if (this.mHasAdSource)
          {
            localJSONObject1 = new JSONObject();
            JSONArray localJSONArray = new JSONArray();
            paramStructMsgNode = paramStructMsgNode.a;
            if ((paramStructMsgNode != null) && (!paramStructMsgNode.isEmpty()))
            {
              paramStructMsgNode = paramStructMsgNode.iterator();
              while (paramStructMsgNode.hasNext())
              {
                Object localObject = ((StructMsgNode)paramStructMsgNode.next()).a;
                if ((localObject != null) && (!((List)localObject).isEmpty()))
                {
                  localObject = ((List)localObject).iterator();
                  while (((Iterator)localObject).hasNext())
                  {
                    StructMsgNode localStructMsgNode = (StructMsgNode)((Iterator)localObject).next();
                    JSONObject localJSONObject2 = new JSONObject();
                    localJSONObject2.put("icon_url", localStructMsgNode.a("icon_url"));
                    localJSONObject2.put("action_type", localStructMsgNode.a("action_type"));
                    localJSONObject2.put("title", localStructMsgNode.a("title"));
                    localJSONObject2.put("action_url", localStructMsgNode.a("action_url"));
                    localJSONArray.put(localJSONObject2);
                  }
                }
              }
            }
            localJSONObject1.put("menus", localJSONArray);
          }
        }
        catch (Exception paramStructMsgNode)
        {
          paramStructMsgNode.printStackTrace();
          return;
        }
      }
      this.mAdSourceMenu = localJSONObject1.toString();
    } while (!QLog.isColorLevel());
    QLog.d("StructMsg", 2, "mAdSourceMenu: " + this.mAdSourceMenu);
  }
  
  protected abstract boolean parseContentNode(StructMsgNode paramStructMsgNode);
  
  protected void parseDataNode(StructMsgNode paramStructMsgNode)
  {
    if (this.mDatas == null) {
      this.mDatas = new JSONObject();
    }
    if (("data".equals(paramStructMsgNode.b)) && (this.mMsgServiceID == 128) && (TextUtils.equals("2", paramStructMsgNode.a("msgtype")))) {}
    try
    {
      this.mDatas.put("groupcode", paramStructMsgNode.a("groupcode"));
      this.mDatas.put("groupname", paramStructMsgNode.a("groupname"));
      this.mDatas.put("msgseq", paramStructMsgNode.a("msgseq"));
      this.mDatas.put("msgtype", paramStructMsgNode.a("msgtype"));
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, "parseDataNode json:" + this.mDatas.toString());
      }
      return;
    }
    catch (JSONException paramStructMsgNode)
    {
      for (;;)
      {
        QLog.d("StructMsg", 1, "parseDataNode error:" + paramStructMsgNode.getMessage());
      }
    }
  }
  
  protected void parseDefaultContentNode()
  {
    AbsStructMsgItem localAbsStructMsgItem = StructMsgElementFactory.a(2);
    localAbsStructMsgItem.a("", this.mMsgBrief, aq);
    addItem(localAbsStructMsgItem);
  }
  
  protected void parseSourceNode(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return;
    }
    this.mSourceAppid = StructMsgUtils.a(paramStructMsgNode.a("appid"));
    this.mSourceName = paramStructMsgNode.a("name");
    if (TextUtils.isEmpty(this.mMsgBrief))
    {
      this.mEmptyMsgBriefModified = true;
      if (TextUtils.isEmpty(this.mSourceName)) {
        break label175;
      }
    }
    label175:
    for (this.mMsgBrief = String.format(ap, new Object[] { this.mSourceName });; this.mMsgBrief = DEFAULT_MSG_BRIEF)
    {
      this.mSourceIcon = paramStructMsgNode.a("icon");
      this.mSourceUrl = paramStructMsgNode.a("url");
      this.mSourceAction = paramStructMsgNode.a("action");
      this.mSourceActionData = paramStructMsgNode.a("actionData");
      this.mSource_A_ActionData = paramStructMsgNode.a("a_actionData");
      this.mSource_I_ActionData = paramStructMsgNode.a("i_actionData");
      if ((this.mHasSource) || ((TextUtils.isEmpty(this.mSourceName)) && (TextUtils.isEmpty(this.mSourceIcon)))) {
        break;
      }
      this.mHasSource = true;
      return;
    }
  }
  
  public abstract void report(Object paramObject);
  
  protected void setCompoundDrawable(TextView paramTextView, Drawable paramDrawable, Resources paramResources)
  {
    paramDrawable = new BitmapDrawable(StructMsgItemCover.a(paramDrawable));
    paramTextView.setCompoundDrawablePadding(AIOUtils.a(3.0F, paramResources));
    paramDrawable.setBounds(0, 0, AIOUtils.a(14.0F, paramResources), AIOUtils.a(14.0F, paramResources));
    paramTextView.setCompoundDrawables(paramDrawable, null, null, null);
  }
  
  public void setHasSource(boolean paramBoolean)
  {
    this.mHasSource = paramBoolean;
  }
  
  public void setSourceIcon(String paramString)
  {
    this.mSourceIcon = paramString;
  }
  
  public void setSourceName(String paramString)
  {
    this.mSourceName = paramString;
  }
  
  public void setStructMsgItemLists(List<AbsStructMsgElement> paramList)
  {
    this.mStructMsgItemLists = paramList;
  }
  
  protected abstract void toContentXml(AbsStructMsg.XmlSerializerWithFilter paramXmlSerializerWithFilter);
  
  protected void toXml(ByteArrayOutputStream paramByteArrayOutputStream, String paramString)
  {
    int i = 1;
    AbsStructMsg.XmlSerializerWithFilter localXmlSerializerWithFilter = new AbsStructMsg.XmlSerializerWithFilter(this, new QQXmlSerializer());
    label797:
    label1064:
    try
    {
      localXmlSerializerWithFilter.setOutput(paramByteArrayOutputStream, paramString);
      localXmlSerializerWithFilter.startDocument(paramString, Boolean.valueOf(true));
      localXmlSerializerWithFilter.startTag(null, "msg");
      localXmlSerializerWithFilter.attribute(null, "serviceID", String.valueOf(this.mMsgServiceID));
      localXmlSerializerWithFilter.attribute(null, "templateID", String.valueOf(this.mMsgTemplateID));
      if (this.mMsgAction != null) {
        break label996;
      }
      paramByteArrayOutputStream = "";
      localXmlSerializerWithFilter.attribute(null, "action", paramByteArrayOutputStream);
      if (!TextUtils.isEmpty(this.mMsgActionData)) {
        localXmlSerializerWithFilter.attribute(null, "actionData", this.mMsgActionData);
      }
      if (!TextUtils.isEmpty(this.mMsg_A_ActionData)) {
        localXmlSerializerWithFilter.attribute(null, "a_actionData", this.mMsg_A_ActionData);
      }
      if (!TextUtils.isEmpty(this.mMsg_I_ActionData)) {
        localXmlSerializerWithFilter.attribute(null, "i_actionData", this.mMsg_I_ActionData);
      }
      if (this.mMsgBrief != null) {
        break label1004;
      }
      paramByteArrayOutputStream = "";
      label185:
      localXmlSerializerWithFilter.attribute(null, "brief", paramByteArrayOutputStream);
      if (!TextUtils.isEmpty(this.mResid)) {
        localXmlSerializerWithFilter.attribute(null, "m_resid", this.mResid);
      }
      if (!TextUtils.isEmpty(this.mFileName)) {
        localXmlSerializerWithFilter.attribute(null, "m_fileName", this.mFileName);
      }
      if (this.mTSum > 0) {
        localXmlSerializerWithFilter.attribute(null, "tSum", String.valueOf(this.mTSum));
      }
      if (this.mFileSize > 0L) {
        localXmlSerializerWithFilter.attribute(null, "m_fileSize", String.valueOf(this.mFileSize));
      }
      if (!TextUtils.isEmpty(this.source_puin)) {
        localXmlSerializerWithFilter.attribute(null, "sourcePublicUin", this.source_puin);
      }
      localXmlSerializerWithFilter.attribute(null, "sourceMsgId", String.valueOf(this.msgId));
      if (this.fwFlag == 1) {
        localXmlSerializerWithFilter.attribute(null, "fwflag", String.valueOf(this.fwFlag));
      }
      if (this.mMsgUrl != null) {
        break label1012;
      }
      paramByteArrayOutputStream = "";
      label371:
      localXmlSerializerWithFilter.attribute(null, "url", paramByteArrayOutputStream);
      if (!TextUtils.isEmpty(this.rijAlbumActionData)) {
        localXmlSerializerWithFilter.attribute(null, "rijAlbumActionData", this.rijAlbumActionData);
      }
      localXmlSerializerWithFilter.attribute(null, "flag", String.valueOf(this.mFlag));
      if (!TextUtils.isEmpty(this.mSType)) {
        localXmlSerializerWithFilter.attribute(null, "sType", this.mSType);
      }
      if (this.sourceAccoutType == SOURCE_ACCOUNT_TYPE_PA) {
        localXmlSerializerWithFilter.attribute(null, "accostType", String.valueOf(SOURCE_ACCOUNT_TYPE_PA));
      }
      paramByteArrayOutputStream = String.valueOf(this.adverSign);
      if (!TextUtils.isEmpty(paramByteArrayOutputStream)) {
        localXmlSerializerWithFilter.attribute(null, "adverSign", paramByteArrayOutputStream);
      }
      if (!TextUtils.isEmpty(this.adverKey)) {
        localXmlSerializerWithFilter.attribute(null, "adverKey", this.adverKey);
      }
      if (!TextUtils.isEmpty(this.mExtraData)) {
        localXmlSerializerWithFilter.attribute(null, "extraData", this.mExtraData);
      }
      if (!TextUtils.isEmpty(this.mCreateTime)) {
        localXmlSerializerWithFilter.attribute(null, "createTime", this.mCreateTime);
      }
      if (!TextUtils.isEmpty(this.mTagName)) {
        localXmlSerializerWithFilter.attribute(null, "tagName", this.mTagName);
      }
      if (!TextUtils.isEmpty(this.mSourceThirdName)) {
        localXmlSerializerWithFilter.attribute(null, "sourceName", this.mSourceThirdName);
      }
      if (!TextUtils.isEmpty(this.mQQStoryExtra)) {
        localXmlSerializerWithFilter.attribute(null, "qqstoryExtra", this.mQQStoryExtra);
      }
      if (!TextUtils.isEmpty(this.mTribeShortVideoExtra)) {
        localXmlSerializerWithFilter.attribute(null, "qqtribeVideoInfoExtra", this.mTribeShortVideoExtra);
      }
      if (!TextUtils.isEmpty(this.mNeedRound)) {
        localXmlSerializerWithFilter.attribute(null, "needRoundView", this.mNeedRound);
      }
      if (!TextUtils.isEmpty(this.mCommonData)) {
        localXmlSerializerWithFilter.attribute(null, "msgCommonData", this.mCommonData);
      }
      localXmlSerializerWithFilter.attribute(null, "multiMsgFlag", String.valueOf(this.multiMsgFlag));
      if (!TextUtils.isEmpty(this.mQzoneExtraMsg)) {
        localXmlSerializerWithFilter.attribute(null, "qzFloatExtra", this.mQzoneExtraMsg);
      }
      toContentXml(localXmlSerializerWithFilter);
      if (this.mMsgServiceID != 128) {
        break label1064;
      }
    }
    catch (Exception paramByteArrayOutputStream)
    {
      label819:
      label996:
      label1004:
      label1012:
      label1020:
      while (QLog.isColorLevel())
      {
        QLog.d("StructMsg", 2, paramByteArrayOutputStream.getMessage(), paramByteArrayOutputStream);
        return;
        i = 0;
      }
    }
    if (i == 0)
    {
      localXmlSerializerWithFilter.startTag(null, "source");
      if (this.mSourceName != null) {
        break label1020;
      }
      paramByteArrayOutputStream = "";
      localXmlSerializerWithFilter.attribute(null, "name", paramByteArrayOutputStream);
      if (this.mSourceIcon != null) {
        break label1028;
      }
      paramByteArrayOutputStream = "";
      localXmlSerializerWithFilter.attribute(null, "icon", paramByteArrayOutputStream);
      if (!TextUtils.isEmpty(this.mSourceUrl)) {
        localXmlSerializerWithFilter.attribute(null, "url", this.mSourceUrl);
      }
      if (this.mSourceAction != null) {
        break label1036;
      }
    }
    label1028:
    label1036:
    for (paramByteArrayOutputStream = "";; paramByteArrayOutputStream = this.mSourceAction)
    {
      localXmlSerializerWithFilter.attribute(null, "action", paramByteArrayOutputStream);
      if (!TextUtils.isEmpty(this.mSourceActionData)) {
        localXmlSerializerWithFilter.attribute(null, "actionData", this.mSourceActionData);
      }
      if (!TextUtils.isEmpty(this.mSource_A_ActionData)) {
        localXmlSerializerWithFilter.attribute(null, "a_actionData", this.mSource_A_ActionData);
      }
      if (!TextUtils.isEmpty(this.mSource_I_ActionData)) {
        localXmlSerializerWithFilter.attribute(null, "i_actionData", this.mSource_I_ActionData);
      }
      localXmlSerializerWithFilter.attribute(null, "appid", String.valueOf(this.mSourceAppid));
      localXmlSerializerWithFilter.endTag(null, "source");
      localXmlSerializerWithFilter.endTag(null, "msg");
      localXmlSerializerWithFilter.endDocument();
      localXmlSerializerWithFilter.flush();
      return;
      paramByteArrayOutputStream = this.mMsgAction;
      break;
      paramByteArrayOutputStream = this.mMsgBrief;
      break label185;
      paramByteArrayOutputStream = this.mMsgUrl;
      break label371;
      paramByteArrayOutputStream = this.mSourceName;
      break label797;
      paramByteArrayOutputStream = this.mSourceIcon;
      break label819;
    }
  }
  
  public void updateCover(String paramString)
  {
    this.mContentCover = paramString;
  }
  
  public void updateTitleSummaryAndCover(String paramString1, String paramString2, String paramString3)
  {
    this.mContentTitle = paramString1;
    this.mContentSummary = paramString2;
    this.mContentCover = paramString3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.AbsShareMsg
 * JD-Core Version:    0.7.0.1
 */