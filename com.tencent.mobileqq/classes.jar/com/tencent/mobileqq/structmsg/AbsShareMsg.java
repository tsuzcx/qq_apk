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
import com.tencent.comic.api.IQQDcReporter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.forward.ForwardOrderManager;
import com.tencent.mobileqq.activity.aio.photo.AIOGallerySceneWithBusiness;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
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
  public String mAdSourceIcon;
  public String mAdSourceMenu;
  public String mAdSourceName;
  public String mContentCover = null;
  public int mContentLayout = -1;
  public String mContentSrc = null;
  public String mContentSummary = null;
  public String mContentTitle = null;
  JSONObject mDatas;
  public boolean mHasAdSource;
  boolean mHasSource;
  public boolean mMsgException;
  public String mSourceAction = null;
  public String mSourceActionData = null;
  public long mSourceAppid = -1L;
  public String mSourceIcon = null;
  public String mSourceName = null;
  protected View.OnClickListener mSourceOnClickListener;
  public String mSourceUrl = null;
  public String mSource_A_ActionData = null;
  public String mSource_I_ActionData = null;
  public List<AbsStructMsgElement> mStructMsgItemLists = new ArrayList();
  public AbsShareMsg.ShareData shareData;
  
  AbsShareMsg()
  {
    this.mMsgException = false;
    this.mAdSourceIcon = null;
    this.mAdSourceName = null;
    this.shareData = new AbsShareMsg.ShareData();
    this.mDatas = null;
    this.mAdSourceMenu = null;
    this.mSourceOnClickListener = new AbsShareMsg.1(this);
    this.mVersion = 28;
  }
  
  AbsShareMsg(Bundle paramBundle)
  {
    super(paramBundle);
    this.mMsgException = false;
    this.mAdSourceIcon = null;
    this.mAdSourceName = null;
    this.shareData = new AbsShareMsg.ShareData();
    this.mDatas = null;
    this.mAdSourceMenu = null;
    this.mSourceOnClickListener = new AbsShareMsg.1(this);
    this.mVersion = 28;
    this.mContentCover = paramBundle.getString("image_url_remote");
    if (this.mContentCover != null)
    {
      this.shareData.imageUrlStatus = paramBundle.getByte("struct_share_key_image_url_status", (byte)4).byteValue();
    }
    else
    {
      this.mContentCover = paramBundle.getString("image_url");
      this.shareData.imageUrlStatus = 2;
    }
    this.mContentTitle = paramBundle.getString("title");
    this.mContentSummary = paramBundle.getString("desc");
    Object localObject = this.mContentTitle;
    if (localObject != null) {
      this.mContentTitle = MessageUtils.a((String)localObject, false);
    }
    localObject = this.mContentSummary;
    if (localObject != null) {
      this.mContentSummary = MessageUtils.a((String)localObject, false);
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
    if (TextUtils.isEmpty(this.mMsgBrief)) {
      if (!TextUtils.isEmpty(this.mSourceName)) {
        this.mMsgBrief = String.format(ap, new Object[] { this.mSourceName });
      } else {
        this.mMsgBrief = DEFAULT_MSG_BRIEF;
      }
    }
    this.mResid = paramBundle.getString("mm_resid");
    this.mFileName = paramBundle.getString("mm_file_name");
    this.mFileSize = paramBundle.getLong("mm_file_size");
    this.mCompatibleText = paramBundle.getString("compatible_text");
    this.fwFlag = paramBundle.getInt("is_share_flag", 0);
    if ((!this.mHasSource) && ((!TextUtils.isEmpty(this.mSourceName)) || (!TextUtils.isEmpty(this.mSourceIcon)))) {
      this.mHasSource = true;
    }
    if ((TextUtils.isEmpty(this.mContentTitle)) && (TextUtils.isEmpty(this.mContentSummary))) {
      if (TextUtils.isEmpty(this.mSourceName)) {
        this.mContentTitle = ao;
      } else {
        this.mContentTitle = String.format(an, new Object[] { this.mSourceName });
      }
    }
    this.mNeedRound = paramBundle.getString("icon_need_round");
    this.mFlag = paramBundle.getInt("flag");
    this.shareData.appInfoStatus = paramBundle.getByte("struct_share_key_app_info_status", (byte)0).byteValue();
    this.shareData.sourceIconBig = paramBundle.getString("struct_share_key_source_icon_big");
    this.shareData.pkgName = paramBundle.getString("pkg_name");
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("msgUrl = ");
      paramBundle.append(this.mMsgUrl);
      paramBundle = new StringBuilder(paramBundle.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(", mVersion = ");
      ((StringBuilder)localObject).append(this.mVersion);
      paramBundle.append(((StringBuilder)localObject).toString());
      paramBundle.append(", mContentCover = ");
      paramBundle.append(this.mContentCover);
      paramBundle.append(", mContentTitle = ");
      paramBundle.append(this.mContentTitle);
      paramBundle.append(", mContentSummary = ");
      paramBundle.append(this.mContentSummary);
      paramBundle.append(", mMsgAction = ");
      paramBundle.append(this.mMsgAction);
      paramBundle.append(", mMsgActionData = ");
      paramBundle.append(this.mMsgActionData);
      paramBundle.append(", mMsg_A_ActionData = ");
      paramBundle.append(this.mMsg_A_ActionData);
      paramBundle.append(", mMsg_I_ActionData = ");
      paramBundle.append(this.mMsg_I_ActionData);
      paramBundle.append(", mSourceAppid = ");
      paramBundle.append(this.mSourceAppid);
      paramBundle.append(", mSourceUrl = ");
      paramBundle.append(this.mSourceUrl);
      paramBundle.append(", mSourceAction = ");
      paramBundle.append(this.mSourceAction);
      paramBundle.append(", mSourceActionData = ");
      paramBundle.append(this.mSourceActionData);
      paramBundle.append(", mSource_A_ActionData = ");
      paramBundle.append(this.mSource_A_ActionData);
      paramBundle.append(", mSource_I_ActionData = ");
      paramBundle.append(this.mSource_I_ActionData);
      paramBundle.append(", mSourceIcon = ");
      paramBundle.append(this.mSourceIcon);
      paramBundle.append(", mSourceName = ");
      paramBundle.append(this.mSourceName);
      paramBundle.append(", mMsgBrief = ");
      paramBundle.append(this.mMsgBrief);
      paramBundle.append(", mResid = ");
      paramBundle.append(this.mResid);
      paramBundle.append(", mFileName = ");
      paramBundle.append(this.mFileName);
      paramBundle.append(", mFileSize = ");
      paramBundle.append(this.mFileSize);
      paramBundle.append(", mCompatibleText = ");
      paramBundle.append(this.mCompatibleText);
      paramBundle.append(", fwFlag = ");
      paramBundle.append(this.fwFlag);
      paramBundle.append(", mHasSource = ");
      paramBundle.append(this.mHasSource);
      paramBundle.append(", mSType = ");
      paramBundle.append(this.mSType);
      QLog.d("StructMsg", 2, paramBundle.toString());
    }
  }
  
  AbsShareMsg(StructMsgNode paramStructMsgNode)
  {
    super(paramStructMsgNode);
    int i = 0;
    this.mMsgException = false;
    this.mAdSourceIcon = null;
    this.mAdSourceName = null;
    this.shareData = new AbsShareMsg.ShareData();
    this.mDatas = null;
    this.mAdSourceMenu = null;
    this.mSourceOnClickListener = new AbsShareMsg.1(this);
    this.mVersion = 28;
    int m = paramStructMsgNode.a();
    int k;
    for (int j = 0; i < m; j = k)
    {
      StructMsgNode localStructMsgNode = paramStructMsgNode.a(i);
      if (localStructMsgNode == null)
      {
        k = j;
      }
      else if (localStructMsgNode.b.equals("source"))
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
      i += 1;
    }
  }
  
  private int a(String[] paramArrayOfString)
  {
    if (a(paramArrayOfString)) {
      return 4;
    }
    if (b(paramArrayOfString)) {
      return 8;
    }
    return -1;
  }
  
  private void a(Context paramContext)
  {
    Object localObject = new ActivityURIRequest(paramContext, "/base/vipcomic");
    ((ActivityURIRequest)localObject).extra().putString("options", "{\"from\":28, \"mod\":\"4008004\"}");
    QRoute.startUri((URIRequest)localObject, null);
    String[] arrayOfString = AIOGallerySceneWithBusiness.a(this.mMsgActionData);
    if ((arrayOfString != null) && (arrayOfString.length >= 8))
    {
      int i = a(arrayOfString);
      if (i == -1) {
        localObject = "";
      } else {
        localObject = arrayOfString[i];
      }
      ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).reportDC00145(null, this.uin, paramContext, "3009", "2", "40059", arrayOfString[0], new String[] { arrayOfString[2], arrayOfString[4], localObject });
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
    Object localObject = this.mStructMsgItemLists;
    if (localObject != null)
    {
      if (((List)localObject).isEmpty()) {
        return false;
      }
      localObject = (AbsStructMsgElement)this.mStructMsgItemLists.get(0);
      if (!(localObject instanceof StructMsgItemLayoutDefault)) {
        return false;
      }
      localObject = (StructMsgItemLayoutDefault)localObject;
      if (((StructMsgItemLayoutDefault)localObject).a != null)
      {
        if (((StructMsgItemLayoutDefault)localObject).a.isEmpty()) {
          return false;
        }
        localObject = (AbsStructMsgElement)((StructMsgItemLayoutDefault)localObject).a.get(0);
        if (!(localObject instanceof StructMsgItemImage)) {
          return false;
        }
        return ((StructMsgItemImage)localObject).a();
      }
    }
    return false;
  }
  
  private boolean a(String[] paramArrayOfString)
  {
    return paramArrayOfString[7].equals("link");
  }
  
  private boolean b(String[] paramArrayOfString)
  {
    return (paramArrayOfString[7].equals("scrawl_link")) && (paramArrayOfString.length >= 9);
  }
  
  public static final void doReport(QQAppInterface paramQQAppInterface, AbsShareMsg paramAbsShareMsg)
  {
    StatisticCollector.getInstance(BaseApplication.getContext()).reportActionCount(paramQQAppInterface, paramAbsShareMsg.uin, "Structured_msg", "Clk_smsg", 0, 1, null, String.valueOf(paramAbsShareMsg.mSourceAppid), String.valueOf(paramAbsShareMsg.mMsgServiceID), paramAbsShareMsg.mMsgAction, null);
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("doReport msg:");
      paramQQAppInterface.append(paramAbsShareMsg);
      QLog.d("StructMsg", 2, paramQQAppInterface.toString());
    }
  }
  
  public static final String[] parsePackageNameAndData(String paramString1, String paramString2)
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "";
    arrayOfString[1] = "";
    if (!TextUtils.isEmpty(paramString2)) {
      paramString1 = paramString2;
    }
    int i;
    if (TextUtils.isEmpty(paramString1)) {
      i = -1;
    } else {
      i = paramString1.indexOf("://");
    }
    if (i == -1)
    {
      arrayOfString[0] = paramString1;
      return arrayOfString;
    }
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
    paramString1 = MessageRecordFactory.a(paramQQAppInterface, str, paramString1, paramString2, paramInt, l, paramAbsShareMsg);
    ForwardOrderManager.a().a(paramString1.uniseq, paramAbsShareMsg.parentUniseq, paramAbsShareMsg.forwardID);
    paramQQAppInterface.getMessageFacade().a(paramString1, MessageHandler.c);
    paramAbsShareMsg = ForwardSdkShareProcessor.buildTransferRequestFromMessage(paramString1, paramAbsShareMsg);
    ((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync(paramAbsShareMsg);
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
    paramString1 = MessageRecordFactory.a(paramQQAppInterface, str, paramString1, paramString2, paramInt, l, paramAbsShareMsg);
    ForwardOrderManager.a().a(paramString1.uniseq, paramAbsShareMsg.parentUniseq, paramAbsShareMsg.forwardID);
    a(paramQQAppInterface, ForwardSdkShareProcessor.buildTransferRequestFromMessageExtra(paramString1, paramAbsShareMsg, paramUpCallBack));
    QLog.d("StructMsg", 1, "sendSdkShareMessageByServer");
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
    while (i < j)
    {
      Object localObject = getItemByIndex(i);
      if (localObject != null)
      {
        if ((localObject instanceof AbsStructMsgItem))
        {
          localObject = ((AbsStructMsgItem)localObject).a.iterator();
          AbsStructMsgElement localAbsStructMsgElement;
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localAbsStructMsgElement = (AbsStructMsgElement)((Iterator)localObject).next();
          } while (!paramString.equals(localAbsStructMsgElement.a));
          return localAbsStructMsgElement;
        }
        if (paramString.equals(((AbsStructMsgElement)localObject).a)) {
          return localObject;
        }
      }
      i += 1;
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
    }
    catch (Exception localException)
    {
      label61:
      Iterator localIterator;
      break label61;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StructMsg", 2, "shareMsg preDialogView setMaxHeight error!");
    }
    ((LinearLayout.LayoutParams)localObject1).gravity = 1;
    localHeightLimitedLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = new Bundle();
    ((Bundle)localObject1).putBoolean("pre_dialog", true);
    localIterator = this.mStructMsgItemLists.iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (AbsStructMsgElement)localIterator.next();
      View localView = ((AbsStructMsgElement)localObject2).a(paramContext, paramView, (Bundle)localObject1);
      if ((localView != null) && ((!(localObject2 instanceof StructMsgItemLayoutDefault)) || (((StructMsgItemLayoutDefault)localObject2).o != 1)))
      {
        if ((localObject2 instanceof StructMsgItemLayout2))
        {
          TextView localTextView = (TextView)localView.findViewById(2131379930);
          if (localTextView != null)
          {
            localObject2 = (StructMsgItemLayout2)localObject2;
            if ((((StructMsgItemLayout2)localObject2).o != 1) && (((StructMsgItemLayout2)localObject2).o != 3))
            {
              localTextView.setGravity(16);
              localTextView.setMaxLines(2);
              localTextView.setTextSize(14.0F);
              localTextView.setTextColor(paramContext.getResources().getColor(2131165660));
              if (TextUtils.isEmpty(localTextView.getText()))
              {
                localTextView.setText("");
                localTextView.setVisibility(0);
              }
            }
            else
            {
              localTextView.setTextColor(-8355712);
            }
          }
        }
        localHeightLimitedLinearLayout.addView(localView);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("[@]", 2, "AbsShareMsg getPreDialogView end!");
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
    Object localObject1 = paramView;
    if (paramView == null)
    {
      localObject1 = new TextView(paramContext);
      ((TextView)localObject1).setSingleLine(true);
      ((TextView)localObject1).setGravity(16);
      ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject1).setTextColor(-1);
      ((TextView)localObject1).setTextSize(2, 12.0F);
    }
    TextView localTextView = (TextView)localObject1;
    localTextView.setText(this.mSourceName);
    localTextView.setBackgroundResource(2130842703);
    Object localObject2;
    Drawable localDrawable;
    if (!TextUtils.isEmpty(this.mSourceIcon))
    {
      localObject2 = this.mSourceIcon;
      localDrawable = localResources.getDrawable(2130850833);
      localDrawable.setBounds(0, 0, AIOUtils.b(12.0F, localResources), AIOUtils.b(12.0F, localResources));
      paramView = localResources.getDrawable(2130850834);
      paramView.setBounds(0, 0, AIOUtils.b(12.0F, localResources), AIOUtils.b(12.0F, localResources));
    }
    for (;;)
    {
      try
      {
        localObject2 = URLDrawable.getDrawable((String)localObject2, localDrawable, paramView);
        if (URLDrawableHelper.isMobileNetAndAutodownDisabled(paramContext)) {
          break label331;
        }
        bool = true;
        ((URLDrawable)localObject2).setAutoDownload(bool);
        paramContext = (Context)localObject2;
      }
      catch (Exception paramContext)
      {
        QLog.e("StructMsg", 1, paramContext.getMessage(), paramContext);
        paramContext = paramView;
      }
      setCompoundDrawable(localTextView, paramContext, localResources);
      break label258;
      localTextView.setCompoundDrawables(null, null, null, null);
      label258:
      localTextView.setPadding(AIOUtils.b(5.0F, localResources), 0, AIOUtils.b(5.0F, localResources), 0);
      ((View)localObject1).setTag(this);
      ((View)localObject1).setOnClickListener(this.mSourceOnClickListener);
      if (a())
      {
        ((View)localObject1).setClickable(false);
        QLog.d("StructMsg", 1, "mSourceOnClickListener =========forbidClickForImageShare ========= ");
        return localObject1;
      }
      ((View)localObject1).setClickable(true);
      return localObject1;
      label331:
      bool = false;
    }
  }
  
  public List<AbsStructMsgElement> getStructMsgItemLists()
  {
    return this.mStructMsgItemLists;
  }
  
  public String getTalkBackStr()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    try
    {
      if (this.mStructMsgItemLists != null)
      {
        Iterator localIterator = this.mStructMsgItemLists.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (AbsStructMsgElement)localIterator.next();
          AbsStructMsgElement localAbsStructMsgElement;
          if ((localObject instanceof StructMsgItemLayout1))
          {
            localObject = ((StructMsgItemLayout1)localObject).a.iterator();
            while (((Iterator)localObject).hasNext())
            {
              localAbsStructMsgElement = (AbsStructMsgElement)((Iterator)localObject).next();
              if ((localAbsStructMsgElement instanceof StructMsgItemTitle)) {
                localStringBuffer.append(((StructMsgItemTitle)localAbsStructMsgElement).ai);
              }
            }
          }
          else if ((localObject instanceof StructMsgItemLayout2))
          {
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
          else if ((localObject instanceof StructMsgItemLayout29))
          {
            localObject = (StructMsgItemLayout29)localObject;
            int i = 0;
            localObject = ((StructMsgItemLayout29)localObject).a.iterator();
            while (((Iterator)localObject).hasNext())
            {
              localAbsStructMsgElement = (AbsStructMsgElement)((Iterator)localObject).next();
              if (("type".equals(localAbsStructMsgElement.a)) && ((localAbsStructMsgElement instanceof StructMsgItemType))) {
                i = ((StructMsgItemType)localAbsStructMsgElement).o;
              }
            }
            if (i != 2)
            {
              if (i != 3) {
                localStringBuffer.append("文本");
              } else {
                localStringBuffer.append("语音");
              }
            }
            else {
              localStringBuffer.append("图片");
            }
            localStringBuffer.append("回执消息");
            if (this.message.isSend()) {
              localStringBuffer.append(",查看阅读状态");
            } else if ("1".equals(ReceiptMsgManager.a(this.message))) {
              localStringBuffer.append(",已读");
            } else {
              localStringBuffer.append(",未读");
            }
          }
        }
      }
    }
    catch (Exception localException)
    {
      label405:
      break label405;
    }
    return localStringBuffer.toString();
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
    if (paramStructMsgNode == null) {
      return;
    }
    this.mAdSourceName = paramStructMsgNode.a("name");
    if (!this.mAdSourceName.equals("")) {
      this.mHasAdSource = true;
    }
    try
    {
      if (this.mHasAdSource)
      {
        JSONObject localJSONObject1 = new JSONObject();
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
        this.mAdSourceMenu = localJSONObject1.toString();
        if (QLog.isColorLevel())
        {
          paramStructMsgNode = new StringBuilder();
          paramStructMsgNode.append("mAdSourceMenu: ");
          paramStructMsgNode.append(this.mAdSourceMenu);
          QLog.d("StructMsg", 2, paramStructMsgNode.toString());
          return;
        }
      }
    }
    catch (Exception paramStructMsgNode)
    {
      paramStructMsgNode.printStackTrace();
    }
  }
  
  protected abstract boolean parseContentNode(StructMsgNode paramStructMsgNode);
  
  protected void parseDataNode(StructMsgNode paramStructMsgNode)
  {
    if (this.mDatas == null) {
      this.mDatas = new JSONObject();
    }
    if (("data".equals(paramStructMsgNode.b)) && (this.mMsgServiceID == 128) && (TextUtils.equals("2", paramStructMsgNode.a("msgtype"))))
    {
      try
      {
        this.mDatas.put("groupcode", paramStructMsgNode.a("groupcode"));
        this.mDatas.put("groupname", paramStructMsgNode.a("groupname"));
        this.mDatas.put("msgseq", paramStructMsgNode.a("msgseq"));
        this.mDatas.put("msgtype", paramStructMsgNode.a("msgtype"));
      }
      catch (JSONException paramStructMsgNode)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("parseDataNode error:");
        localStringBuilder.append(paramStructMsgNode.getMessage());
        QLog.d("StructMsg", 1, localStringBuilder.toString());
      }
      if (QLog.isColorLevel())
      {
        paramStructMsgNode = new StringBuilder();
        paramStructMsgNode.append("parseDataNode json:");
        paramStructMsgNode.append(this.mDatas.toString());
        QLog.d("StructMsg", 2, paramStructMsgNode.toString());
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
      if (!TextUtils.isEmpty(this.mSourceName)) {
        this.mMsgBrief = String.format(ap, new Object[] { this.mSourceName });
      } else {
        this.mMsgBrief = DEFAULT_MSG_BRIEF;
      }
    }
    this.mSourceIcon = paramStructMsgNode.a("icon");
    this.mSourceUrl = paramStructMsgNode.a("url");
    this.mSourceAction = paramStructMsgNode.a("action");
    this.mSourceActionData = paramStructMsgNode.a("actionData");
    this.mSource_A_ActionData = paramStructMsgNode.a("a_actionData");
    this.mSource_I_ActionData = paramStructMsgNode.a("i_actionData");
    if ((!this.mHasSource) && ((!TextUtils.isEmpty(this.mSourceName)) || (!TextUtils.isEmpty(this.mSourceIcon)))) {
      this.mHasSource = true;
    }
  }
  
  public abstract void report(Object paramObject);
  
  protected void setCompoundDrawable(TextView paramTextView, Drawable paramDrawable, Resources paramResources)
  {
    paramDrawable = new BitmapDrawable(StructMsgItemCover.a(paramDrawable));
    paramTextView.setCompoundDrawablePadding(AIOUtils.b(3.0F, paramResources));
    paramDrawable.setBounds(0, 0, AIOUtils.b(14.0F, paramResources), AIOUtils.b(14.0F, paramResources));
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
    AbsStructMsg.XmlSerializerWithFilter localXmlSerializerWithFilter = new AbsStructMsg.XmlSerializerWithFilter(this, new QQXmlSerializer());
    for (;;)
    {
      try
      {
        localXmlSerializerWithFilter.setOutput(paramByteArrayOutputStream, paramString);
        i = 1;
        localXmlSerializerWithFilter.startDocument(paramString, Boolean.valueOf(true));
        localXmlSerializerWithFilter.startTag(null, "msg");
        localXmlSerializerWithFilter.attribute(null, "serviceID", String.valueOf(this.mMsgServiceID));
        localXmlSerializerWithFilter.attribute(null, "templateID", String.valueOf(this.mMsgTemplateID));
        paramByteArrayOutputStream = this.mMsgAction;
        paramString = "";
        if (paramByteArrayOutputStream == null) {
          paramByteArrayOutputStream = "";
        } else {
          paramByteArrayOutputStream = this.mMsgAction;
        }
        localXmlSerializerWithFilter.attribute(null, "action", paramByteArrayOutputStream);
        boolean bool = TextUtils.isEmpty(this.mMsgActionData);
        if (!bool) {
          localXmlSerializerWithFilter.attribute(null, "actionData", this.mMsgActionData);
        }
        bool = TextUtils.isEmpty(this.mMsg_A_ActionData);
        if (!bool) {
          localXmlSerializerWithFilter.attribute(null, "a_actionData", this.mMsg_A_ActionData);
        }
        bool = TextUtils.isEmpty(this.mMsg_I_ActionData);
        if (!bool) {
          localXmlSerializerWithFilter.attribute(null, "i_actionData", this.mMsg_I_ActionData);
        }
        if (this.mMsgBrief == null) {
          paramByteArrayOutputStream = "";
        } else {
          paramByteArrayOutputStream = this.mMsgBrief;
        }
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
        if (this.mMsgUrl == null) {
          paramByteArrayOutputStream = "";
        } else {
          paramByteArrayOutputStream = this.mMsgUrl;
        }
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
        if (this.mMsgServiceID == 128)
        {
          if (i == 0)
          {
            localXmlSerializerWithFilter.startTag(null, "source");
            if (this.mSourceName == null) {
              paramByteArrayOutputStream = "";
            } else {
              paramByteArrayOutputStream = this.mSourceName;
            }
            localXmlSerializerWithFilter.attribute(null, "name", paramByteArrayOutputStream);
            if (this.mSourceIcon == null) {
              paramByteArrayOutputStream = "";
            } else {
              paramByteArrayOutputStream = this.mSourceIcon;
            }
            localXmlSerializerWithFilter.attribute(null, "icon", paramByteArrayOutputStream);
            if (!TextUtils.isEmpty(this.mSourceUrl)) {
              localXmlSerializerWithFilter.attribute(null, "url", this.mSourceUrl);
            }
            if (this.mSourceAction == null) {
              paramByteArrayOutputStream = paramString;
            } else {
              paramByteArrayOutputStream = this.mSourceAction;
            }
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
          }
          localXmlSerializerWithFilter.endTag(null, "msg");
          localXmlSerializerWithFilter.endDocument();
          localXmlSerializerWithFilter.flush();
          return;
        }
      }
      catch (Exception paramByteArrayOutputStream)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StructMsg", 2, paramByteArrayOutputStream.getMessage(), paramByteArrayOutputStream);
        }
        return;
      }
      int i = 0;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.AbsShareMsg
 * JD-Core Version:    0.7.0.1
 */