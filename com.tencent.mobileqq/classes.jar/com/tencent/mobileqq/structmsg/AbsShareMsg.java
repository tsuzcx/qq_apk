package com.tencent.mobileqq.structmsg;

import actj;
import adgc;
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
import auoq;
import avpg;
import awyn;
import axas;
import axau;
import axrn;
import axul;
import axuo;
import axup;
import axuq;
import axuu;
import axuz;
import axwg;
import axwj;
import axws;
import axwv;
import axww;
import axxi;
import axxz;
import axyo;
import axzj;
import axzr;
import ayqt;
import ayvx;
import aywm;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.structmsg.widget.HeightLimitedLinearLayout;
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
  implements Iterable<axup>
{
  public static final int PACKAGE_NAME_INDEX = 0;
  public static final int URL_DATA_INDEX = 1;
  public int forwardType;
  public String mAdSourceIcon;
  public String mAdSourceMenu;
  public String mAdSourceName;
  public String mContentCover;
  public int mContentLayout = -1;
  public String mContentSrc;
  public String mContentSummary;
  public String mContentTitle;
  JSONObject mDatas = null;
  public boolean mHasAdSource;
  public boolean mHasSource;
  public boolean mMsgException;
  public String mSourceAction;
  public String mSourceActionData;
  public long mSourceAppid = -1L;
  public String mSourceIcon;
  public String mSourceName;
  protected View.OnClickListener mSourceOnClickListener = new axul(this);
  public String mSourceUrl;
  public String mSource_A_ActionData;
  public String mSource_I_ActionData;
  public List<axup> mStructMsgItemLists = new ArrayList();
  public AbsShareMsg.ShareData shareData = new AbsShareMsg.ShareData();
  
  AbsShareMsg()
  {
    this.mVersion = 27;
  }
  
  AbsShareMsg(Bundle paramBundle)
  {
    super(paramBundle);
    this.mVersion = 27;
    this.mContentCover = paramBundle.getString("image_url_remote");
    if (this.mContentCover != null)
    {
      this.shareData.imageUrlStatus = paramBundle.getByte("struct_share_key_image_url_status", (byte)4).byteValue();
      this.mContentTitle = paramBundle.getString("title");
      this.mContentSummary = paramBundle.getString("desc");
      if (this.mContentTitle != null) {
        this.mContentTitle = axau.a(this.mContentTitle, false);
      }
      if (this.mContentSummary != null) {
        this.mContentSummary = axau.a(this.mContentSummary, false);
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
          break label1019;
        }
        this.mMsgBrief = String.format(af, new Object[] { this.mSourceName });
      }
      label437:
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
          break label1029;
        }
      }
    }
    label1029:
    for (this.mContentTitle = ae;; this.mContentTitle = String.format(ad, new Object[] { this.mSourceName }))
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
      label1019:
      this.mMsgBrief = DEFAULT_MSG_BRIEF;
      break label437;
    }
  }
  
  AbsShareMsg(axwg paramaxwg)
  {
    super(paramaxwg);
    this.mVersion = 27;
    int m = paramaxwg.a();
    int i = 0;
    if (i < m)
    {
      axwg localaxwg = paramaxwg.a(i);
      int k;
      if (localaxwg == null) {
        k = j;
      }
      for (;;)
      {
        i += 1;
        j = k;
        break;
        if (localaxwg.b.equals("source"))
        {
          parseSourceNode(localaxwg);
          k = j;
          if (j != 0)
          {
            parseDefaultContentNode();
            k = j;
          }
        }
        else if (localaxwg.b.equals("sourceAd"))
        {
          parseAdSourceNode(localaxwg);
          k = j;
          if (j != 0)
          {
            parseDefaultContentNode();
            k = j;
          }
        }
        else if ((this.mMsgServiceID == 128) && (localaxwg.b.equals("data")))
        {
          parseDataNode(localaxwg);
          k = j;
        }
        else
        {
          k = j;
          if (j == 0)
          {
            k = j;
            if (!parseContentNode(localaxwg))
            {
              this.mStructMsgItemLists.clear();
              k = 1;
            }
          }
        }
      }
    }
  }
  
  private boolean a()
  {
    if (!TextUtils.isEmpty(this.mSourceAction)) {
      return false;
    }
    if ((this.mStructMsgItemLists == null) || (this.mStructMsgItemLists.isEmpty())) {
      return false;
    }
    Object localObject = (axup)this.mStructMsgItemLists.get(0);
    if (!(localObject instanceof axyo)) {
      return false;
    }
    localObject = (axyo)localObject;
    if ((((axyo)localObject).a == null) || (((axyo)localObject).a.isEmpty())) {
      return false;
    }
    localObject = (axup)((axyo)localObject).a.get(0);
    if (!(localObject instanceof axwv)) {
      return false;
    }
    return ((axwv)localObject).a();
  }
  
  public static final void doReport(QQAppInterface paramQQAppInterface, AbsShareMsg paramAbsShareMsg)
  {
    axrn.a(BaseApplication.getContext()).a(paramQQAppInterface, paramAbsShareMsg.uin, "Structured_msg", "Clk_smsg", 0, 1, null, String.valueOf(paramAbsShareMsg.mSourceAppid), String.valueOf(paramAbsShareMsg.mMsgServiceID), paramAbsShareMsg.mMsgAction, null);
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
  
  public static void resendSdkShareMessage(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, AbsShareMsg paramAbsShareMsg)
  {
    paramMessageRecord = axas.a(paramMessageRecord);
    adgc.a().a(paramMessageRecord.uniseq, paramAbsShareMsg.parentUniseq, paramAbsShareMsg.forwardID);
    paramQQAppInterface.a().a(paramMessageRecord, MessageHandler.f);
    paramMessageRecord = ayqt.a(paramMessageRecord, paramAbsShareMsg);
    paramQQAppInterface.a().a(paramMessageRecord);
  }
  
  public static void sendSdkShareMessage(QQAppInterface paramQQAppInterface, AbsShareMsg paramAbsShareMsg, String paramString1, int paramInt, String paramString2)
  {
    int i = awyn.a;
    awyn.a = i + 1;
    long l = i;
    String str = paramQQAppInterface.getCurrentAccountUin();
    if (TextUtils.isEmpty(paramString2)) {
      paramString2 = str;
    }
    for (;;)
    {
      paramString1 = axas.a(paramQQAppInterface, str, paramString1, paramString2, paramInt, l, paramAbsShareMsg);
      adgc.a().a(paramString1.uniseq, paramAbsShareMsg.parentUniseq, paramAbsShareMsg.forwardID);
      paramQQAppInterface.a().a(paramString1, MessageHandler.f);
      paramAbsShareMsg = ayqt.a(paramString1, paramAbsShareMsg);
      paramQQAppInterface.a().a(paramAbsShareMsg);
      return;
    }
  }
  
  public static void sendSdkShareMessageByServer(QQAppInterface paramQQAppInterface, AbsShareMsg paramAbsShareMsg, String paramString1, int paramInt, String paramString2, auoq paramauoq)
  {
    int i = awyn.a;
    awyn.a = i + 1;
    long l = i;
    String str = paramQQAppInterface.getCurrentAccountUin();
    if (TextUtils.isEmpty(paramString2)) {
      paramString2 = str;
    }
    for (;;)
    {
      paramString1 = axas.a(paramQQAppInterface, str, paramString1, paramString2, paramInt, l, paramAbsShareMsg);
      adgc.a().a(paramString1.uniseq, paramAbsShareMsg.parentUniseq, paramAbsShareMsg.forwardID);
      paramAbsShareMsg = ayqt.a(paramString1, paramAbsShareMsg, paramauoq);
      paramQQAppInterface.a().a(paramAbsShareMsg);
      return;
    }
  }
  
  public void addItem(axup paramaxup)
  {
    this.mStructMsgItemLists.add(paramaxup);
  }
  
  public void addItems(List<axup> paramList)
  {
    this.mStructMsgItemLists.addAll(paramList);
  }
  
  public void clearItems()
  {
    this.mStructMsgItemLists.clear();
  }
  
  public axup findXmlNode(String paramString)
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
          if (!(localObject instanceof axuq)) {
            break label98;
          }
          localObject = ((axuq)localObject).a.iterator();
        } while (!((Iterator)localObject).hasNext());
        axup localaxup = (axup)((Iterator)localObject).next();
        if (!paramString.equals(localaxup.a)) {
          break label32;
        }
        return localaxup;
      } while (!paramString.equals(((axup)localObject).a));
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
  
  public axup getItemByIndex(int paramInt)
  {
    return (axup)this.mStructMsgItemLists.get(paramInt);
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
        Object localObject2 = (axup)localIterator.next();
        View localView = ((axup)localObject2).a(paramContext, paramView, (Bundle)localObject1);
        if ((localView != null) && ((!(localObject2 instanceof axyo)) || (((axyo)localObject2).k != 1)))
        {
          if ((localObject2 instanceof axxi))
          {
            localTextView = (TextView)localView.findViewById(2131378383);
            if (localTextView != null)
            {
              localObject2 = (axxi)localObject2;
              if ((((axxi)localObject2).k != 1) && (((axxi)localObject2).k != 3)) {
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
          localTextView.setTextColor(paramContext.getResources().getColor(2131165583));
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
      paramView.setBackgroundResource(2130842093);
    }
    for (;;)
    {
      TextView localTextView = (TextView)paramView;
      localTextView.setText(this.mSourceName);
      Drawable localDrawable1;
      if (!TextUtils.isEmpty(this.mSourceIcon))
      {
        Object localObject = this.mSourceIcon;
        Drawable localDrawable2 = localResources.getDrawable(2130849355);
        localDrawable2.setBounds(0, 0, actj.a(12.0F, localResources), actj.a(12.0F, localResources));
        localDrawable1 = localResources.getDrawable(2130849356);
        localDrawable1.setBounds(0, 0, actj.a(12.0F, localResources), actj.a(12.0F, localResources));
        try
        {
          localObject = URLDrawable.getDrawable((String)localObject, localDrawable2, localDrawable1);
          if (aywm.a(paramContext)) {
            break label324;
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
        paramContext = new BitmapDrawable(axws.a(paramContext));
        localTextView.setCompoundDrawablePadding(actj.a(3.0F, localResources));
        paramContext.setBounds(0, 0, actj.a(14.0F, localResources), actj.a(14.0F, localResources));
        localTextView.setCompoundDrawables(paramContext, null, null, null);
      }
      for (;;)
      {
        localTextView.setPadding(actj.a(5.0F, localResources), 0, actj.a(5.0F, localResources), 0);
        paramView.setTag(this);
        paramView.setOnClickListener(this.mSourceOnClickListener);
        if (!a()) {
          break label360;
        }
        paramView.setClickable(false);
        QLog.d("StructMsg", 1, "mSourceOnClickListener =========forbidClickForImageShare ========= ");
        return paramView;
        label324:
        bool = false;
        break;
        localTextView.setCompoundDrawables(null, null, null, null);
      }
      label360:
      paramView.setClickable(true);
      return paramView;
    }
  }
  
  public List<axup> getStructMsgItemLists()
  {
    return this.mStructMsgItemLists;
  }
  
  public String getTalkBackStr()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    axup localaxup;
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
              localObject = (axup)localIterator.next();
              if (!(localObject instanceof axww)) {
                break label118;
              }
              localObject = ((axww)localObject).a.iterator();
              if (((Iterator)localObject).hasNext())
              {
                localaxup = (axup)((Iterator)localObject).next();
                if (!(localaxup instanceof StructMsgItemTitle)) {
                  continue;
                }
                localStringBuffer.append(((StructMsgItemTitle)localaxup).Y);
                continue;
              }
              continue;
            }
          }
          return localStringBuffer.toString();
        }
        catch (Exception localException) {}
        if (!(localObject instanceof axxi)) {
          break;
        }
        localObject = (axxi)localObject;
        localStringBuffer.append("链接");
        localObject = ((axxi)localObject).a.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localaxup = (axup)((Iterator)localObject).next();
          if ((localaxup instanceof StructMsgItemTitle)) {
            localStringBuffer.append(((StructMsgItemTitle)localaxup).Y);
          } else if ((localaxup instanceof axzj)) {
            localStringBuffer.append(((axzj)localaxup).Y);
          }
        }
      }
    } while (!(localObject instanceof axxz));
    Object localObject = (axxz)localObject;
    int i = 0;
    localObject = ((axxz)localObject).a.iterator();
    label248:
    if (((Iterator)localObject).hasNext())
    {
      localaxup = (axup)((Iterator)localObject).next();
      if (("type".equals(localaxup.a)) && ((localaxup instanceof axzr))) {
        i = ((axzr)localaxup).k;
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
      if ("1".equals(avpg.a(this.message)))
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
  
  public Iterator<axup> iterator()
  {
    return this.mStructMsgItemLists.iterator();
  }
  
  protected void parseAdSourceNode(axwg paramaxwg)
  {
    if (paramaxwg == null) {}
    do
    {
      JSONObject localJSONObject1;
      for (;;)
      {
        return;
        this.mAdSourceName = paramaxwg.a("name");
        if (!this.mAdSourceName.equals("")) {
          this.mHasAdSource = true;
        }
        try
        {
          if (this.mHasAdSource)
          {
            localJSONObject1 = new JSONObject();
            JSONArray localJSONArray = new JSONArray();
            paramaxwg = paramaxwg.a;
            if ((paramaxwg != null) && (!paramaxwg.isEmpty()))
            {
              paramaxwg = paramaxwg.iterator();
              while (paramaxwg.hasNext())
              {
                Object localObject = ((axwg)paramaxwg.next()).a;
                if ((localObject != null) && (!((List)localObject).isEmpty()))
                {
                  localObject = ((List)localObject).iterator();
                  while (((Iterator)localObject).hasNext())
                  {
                    axwg localaxwg = (axwg)((Iterator)localObject).next();
                    JSONObject localJSONObject2 = new JSONObject();
                    localJSONObject2.put("icon_url", localaxwg.a("icon_url"));
                    localJSONObject2.put("action_type", localaxwg.a("action_type"));
                    localJSONObject2.put("title", localaxwg.a("title"));
                    localJSONObject2.put("action_url", localaxwg.a("action_url"));
                    localJSONArray.put(localJSONObject2);
                  }
                }
              }
            }
            localJSONObject1.put("menus", localJSONArray);
          }
        }
        catch (Exception paramaxwg)
        {
          paramaxwg.printStackTrace();
          return;
        }
      }
      this.mAdSourceMenu = localJSONObject1.toString();
    } while (!QLog.isColorLevel());
    QLog.d("StructMsg", 2, "mAdSourceMenu: " + this.mAdSourceMenu);
  }
  
  protected abstract boolean parseContentNode(axwg paramaxwg);
  
  protected void parseDataNode(axwg paramaxwg)
  {
    if (this.mDatas == null) {
      this.mDatas = new JSONObject();
    }
    if (("data".equals(paramaxwg.b)) && (this.mMsgServiceID == 128) && (TextUtils.equals("2", paramaxwg.a("msgtype")))) {}
    try
    {
      this.mDatas.put("groupcode", paramaxwg.a("groupcode"));
      this.mDatas.put("groupname", paramaxwg.a("groupname"));
      this.mDatas.put("msgseq", paramaxwg.a("msgseq"));
      this.mDatas.put("msgtype", paramaxwg.a("msgtype"));
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, "parseDataNode json:" + this.mDatas.toString());
      }
      return;
    }
    catch (JSONException paramaxwg)
    {
      for (;;)
      {
        QLog.d("StructMsg", 1, "parseDataNode error:" + paramaxwg.getMessage());
      }
    }
  }
  
  protected void parseDefaultContentNode()
  {
    axuq localaxuq = axuz.a(2);
    localaxuq.a("", this.mMsgBrief, ag);
    addItem(localaxuq);
  }
  
  protected void parseSourceNode(axwg paramaxwg)
  {
    if (paramaxwg == null) {
      return;
    }
    this.mSourceAppid = axwj.a(paramaxwg.a("appid"));
    this.mSourceName = paramaxwg.a("name");
    if (TextUtils.isEmpty(this.mMsgBrief))
    {
      this.mEmptyMsgBriefModified = true;
      if (TextUtils.isEmpty(this.mSourceName)) {
        break label175;
      }
    }
    label175:
    for (this.mMsgBrief = String.format(af, new Object[] { this.mSourceName });; this.mMsgBrief = DEFAULT_MSG_BRIEF)
    {
      this.mSourceIcon = paramaxwg.a("icon");
      this.mSourceUrl = paramaxwg.a("url");
      this.mSourceAction = paramaxwg.a("action");
      this.mSourceActionData = paramaxwg.a("actionData");
      this.mSource_A_ActionData = paramaxwg.a("a_actionData");
      this.mSource_I_ActionData = paramaxwg.a("i_actionData");
      if ((this.mHasSource) || ((TextUtils.isEmpty(this.mSourceName)) && (TextUtils.isEmpty(this.mSourceIcon)))) {
        break;
      }
      this.mHasSource = true;
      return;
    }
  }
  
  public abstract void report(Object paramObject);
  
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
  
  public void setStructMsgItemLists(List<axup> paramList)
  {
    this.mStructMsgItemLists = paramList;
  }
  
  protected abstract void toContentXml(axuo paramaxuo);
  
  protected void toXml(ByteArrayOutputStream paramByteArrayOutputStream, String paramString)
  {
    int i = 1;
    axuo localaxuo = new axuo(this, new axuu());
    label773:
    label1040:
    try
    {
      localaxuo.setOutput(paramByteArrayOutputStream, paramString);
      localaxuo.startDocument(paramString, Boolean.valueOf(true));
      localaxuo.startTag(null, "msg");
      localaxuo.attribute(null, "serviceID", String.valueOf(this.mMsgServiceID));
      localaxuo.attribute(null, "templateID", String.valueOf(this.mMsgTemplateID));
      if (this.mMsgAction != null) {
        break label972;
      }
      paramByteArrayOutputStream = "";
      localaxuo.attribute(null, "action", paramByteArrayOutputStream);
      if (!TextUtils.isEmpty(this.mMsgActionData)) {
        localaxuo.attribute(null, "actionData", this.mMsgActionData);
      }
      if (!TextUtils.isEmpty(this.mMsg_A_ActionData)) {
        localaxuo.attribute(null, "a_actionData", this.mMsg_A_ActionData);
      }
      if (!TextUtils.isEmpty(this.mMsg_I_ActionData)) {
        localaxuo.attribute(null, "i_actionData", this.mMsg_I_ActionData);
      }
      if (this.mMsgBrief != null) {
        break label980;
      }
      paramByteArrayOutputStream = "";
      label185:
      localaxuo.attribute(null, "brief", paramByteArrayOutputStream);
      if (!TextUtils.isEmpty(this.mResid)) {
        localaxuo.attribute(null, "m_resid", this.mResid);
      }
      if (!TextUtils.isEmpty(this.mFileName)) {
        localaxuo.attribute(null, "m_fileName", this.mFileName);
      }
      if (this.mTSum > 0) {
        localaxuo.attribute(null, "tSum", String.valueOf(this.mTSum));
      }
      if (this.mFileSize > 0L) {
        localaxuo.attribute(null, "m_fileSize", String.valueOf(this.mFileSize));
      }
      if (!TextUtils.isEmpty(this.source_puin)) {
        localaxuo.attribute(null, "sourcePublicUin", this.source_puin);
      }
      localaxuo.attribute(null, "sourceMsgId", String.valueOf(this.msgId));
      if (this.fwFlag == 1) {
        localaxuo.attribute(null, "fwflag", String.valueOf(this.fwFlag));
      }
      if (this.mMsgUrl != null) {
        break label988;
      }
      paramByteArrayOutputStream = "";
      label371:
      localaxuo.attribute(null, "url", paramByteArrayOutputStream);
      if (!TextUtils.isEmpty(this.rijAlbumActionData)) {
        localaxuo.attribute(null, "rijAlbumActionData", this.rijAlbumActionData);
      }
      localaxuo.attribute(null, "flag", String.valueOf(this.mFlag));
      if (!TextUtils.isEmpty(this.mSType)) {
        localaxuo.attribute(null, "sType", this.mSType);
      }
      if (this.sourceAccoutType == SOURCE_ACCOUNT_TYPE_PA) {
        localaxuo.attribute(null, "accostType", String.valueOf(SOURCE_ACCOUNT_TYPE_PA));
      }
      paramByteArrayOutputStream = String.valueOf(this.adverSign);
      if (!TextUtils.isEmpty(paramByteArrayOutputStream)) {
        localaxuo.attribute(null, "adverSign", paramByteArrayOutputStream);
      }
      if (!TextUtils.isEmpty(this.adverKey)) {
        localaxuo.attribute(null, "adverKey", this.adverKey);
      }
      if (!TextUtils.isEmpty(this.mExtraData)) {
        localaxuo.attribute(null, "extraData", this.mExtraData);
      }
      if (!TextUtils.isEmpty(this.mCreateTime)) {
        localaxuo.attribute(null, "createTime", this.mCreateTime);
      }
      if (!TextUtils.isEmpty(this.mTagName)) {
        localaxuo.attribute(null, "tagName", this.mTagName);
      }
      if (!TextUtils.isEmpty(this.mSourceThirdName)) {
        localaxuo.attribute(null, "sourceName", this.mSourceThirdName);
      }
      if (!TextUtils.isEmpty(this.mQQStoryExtra)) {
        localaxuo.attribute(null, "qqstoryExtra", this.mQQStoryExtra);
      }
      if (!TextUtils.isEmpty(this.mTribeShortVideoExtra)) {
        localaxuo.attribute(null, "qqtribeVideoInfoExtra", this.mTribeShortVideoExtra);
      }
      if (!TextUtils.isEmpty(this.mNeedRound)) {
        localaxuo.attribute(null, "needRoundView", this.mNeedRound);
      }
      if (!TextUtils.isEmpty(this.mCommonData)) {
        localaxuo.attribute(null, "msgCommonData", this.mCommonData);
      }
      localaxuo.attribute(null, "multiMsgFlag", String.valueOf(this.multiMsgFlag));
      toContentXml(localaxuo);
      if (this.mMsgServiceID != 128) {
        break label1040;
      }
    }
    catch (Exception paramByteArrayOutputStream)
    {
      label795:
      label972:
      label980:
      label988:
      label996:
      label1004:
      label1012:
      while (QLog.isColorLevel())
      {
        QLog.d("StructMsg", 2, paramByteArrayOutputStream.getMessage(), paramByteArrayOutputStream);
        return;
        i = 0;
      }
    }
    if (i == 0)
    {
      localaxuo.startTag(null, "source");
      if (this.mSourceName != null) {
        break label996;
      }
      paramByteArrayOutputStream = "";
      localaxuo.attribute(null, "name", paramByteArrayOutputStream);
      if (this.mSourceIcon != null) {
        break label1004;
      }
      paramByteArrayOutputStream = "";
      localaxuo.attribute(null, "icon", paramByteArrayOutputStream);
      if (!TextUtils.isEmpty(this.mSourceUrl)) {
        localaxuo.attribute(null, "url", this.mSourceUrl);
      }
      if (this.mSourceAction != null) {
        break label1012;
      }
    }
    for (paramByteArrayOutputStream = "";; paramByteArrayOutputStream = this.mSourceAction)
    {
      localaxuo.attribute(null, "action", paramByteArrayOutputStream);
      if (!TextUtils.isEmpty(this.mSourceActionData)) {
        localaxuo.attribute(null, "actionData", this.mSourceActionData);
      }
      if (!TextUtils.isEmpty(this.mSource_A_ActionData)) {
        localaxuo.attribute(null, "a_actionData", this.mSource_A_ActionData);
      }
      if (!TextUtils.isEmpty(this.mSource_I_ActionData)) {
        localaxuo.attribute(null, "i_actionData", this.mSource_I_ActionData);
      }
      localaxuo.attribute(null, "appid", String.valueOf(this.mSourceAppid));
      localaxuo.endTag(null, "source");
      localaxuo.endTag(null, "msg");
      localaxuo.endDocument();
      localaxuo.flush();
      return;
      paramByteArrayOutputStream = this.mMsgAction;
      break;
      paramByteArrayOutputStream = this.mMsgBrief;
      break label185;
      paramByteArrayOutputStream = this.mMsgUrl;
      break label371;
      paramByteArrayOutputStream = this.mSourceName;
      break label773;
      paramByteArrayOutputStream = this.mSourceIcon;
      break label795;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.AbsShareMsg
 * JD-Core Version:    0.7.0.1
 */