package com.tencent.mobileqq.structmsg;

import aekt;
import aeov;
import alpo;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import azqs;
import azsa;
import azsd;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.Externalizable;
import java.io.UnsupportedEncodingException;
import org.json.JSONObject;

public abstract class AbsStructMsg
  implements azqs, Externalizable
{
  public static final String DEFAULT_MSG_BRIEF = alpo.a(2131700094);
  public static final String PA_DEFAULT_MSG_BRIEF = alpo.a(2131700093);
  public static int SOURCE_ACCOUNT_TYPE_PA = 7;
  public String adverKey;
  public int adverSign;
  public String currentAccountUin;
  public int dynamicMsgMergeIndex = -1;
  public String dynamicMsgMergeKey = "";
  public int forwardID;
  public int fwFlag;
  public String index;
  public String index_name;
  public String index_type;
  public String mAlgorithmIds;
  public String mArticleIds;
  public String mCommentText;
  public String mCommonData;
  public String mCompatibleText = "";
  public String mCreateTime;
  public boolean mEmptyMsgBriefModified;
  public String mExtraData;
  public String mFileName;
  public long mFileSize;
  public int mFlag;
  public String mInnerUniqIds;
  public String mMergeSeq;
  public String mMsgAction = "web";
  public String mMsgActionData;
  public String mMsgBrief;
  public String mMsgOldText;
  public int mMsgServiceID = -1;
  public int mMsgTemplateID = -1;
  public String mMsgUrl;
  public String mMsg_A_ActionData;
  public String mMsg_I_ActionData;
  public String mNeedRound;
  public String mOrangeWord;
  public int mPromotionMenuDestructiveIndex = -1;
  public String mPromotionMenus = "";
  public String mPromotionMsg = "";
  public int mPromotionType;
  public String mQQStoryExtra;
  public String mQidianBulkTaskId;
  public String mQzoneExtraMsg;
  public String mResid;
  public String mSType;
  public long mSortKey;
  public String mSourceThirdName;
  public String mStrategyIds;
  public int mTSum;
  public String mTagName;
  public String mTribeShortVideoExtra;
  public int mVersion = 1;
  public MessageRecord message;
  public int messageVersion;
  public long msgId;
  public int multiMsgFlag;
  public long parentUniseq;
  public String readInjoy = "QQ看点";
  public String reportEventFolderStatusValue;
  public String rijAlbumActionData;
  public int sourceAccoutType;
  public String source_puin = "";
  public String templateIDForPortal = "";
  public String uin;
  public int uinType;
  public long uniseq;
  
  AbsStructMsg() {}
  
  AbsStructMsg(Bundle paramBundle)
  {
    this.mMsgTemplateID = 1;
    this.mMsgServiceID = 1;
    this.mMsgAction = "web";
    this.mMsgActionData = "";
    this.mMsgUrl = paramBundle.getString("detail_url");
    this.mQzoneExtraMsg = paramBundle.getString("qzone_extra_msg");
    this.mMsg_A_ActionData = "";
    this.mCommentText = paramBundle.getString("share_comment_message");
    this.source_puin = paramBundle.getString("source_puin");
    if ((this.source_puin == null) || (this.source_puin.equals(""))) {
      this.source_puin = paramBundle.getString("struct_uin");
    }
    if (this.source_puin == null) {
      this.source_puin = "";
    }
    if (this.msgId == 0L) {
      paramBundle = paramBundle.getString("strurt_msgid");
    }
    try
    {
      this.msgId = Long.parseLong(paramBundle);
      return;
    }
    catch (Exception paramBundle) {}
  }
  
  AbsStructMsg(azsa paramazsa)
  {
    parseMsgAttrubutes(paramazsa);
  }
  
  public static View getExceptionView(Context paramContext, View paramView, aeov paramaeov, Bundle paramBundle, int paramInt)
  {
    return getExceptionView(paramContext, paramView, paramaeov, paramBundle, paramContext.getResources().getString(paramInt));
  }
  
  public static View getExceptionView(Context paramContext, View paramView, aeov paramaeov, Bundle paramBundle, String paramString)
  {
    paramaeov = paramContext.getResources();
    if ((paramView != null) && ((paramView instanceof RelativeLayout))) {
      ((RelativeLayout)paramView).removeAllViews();
    }
    for (;;)
    {
      paramView = (RelativeLayout)paramView;
      paramView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
      paramBundle = new TextView(paramContext);
      paramBundle.setText(paramString);
      paramBundle.setTextSize(2, 14.0F);
      paramBundle.setTextColor(Color.parseColor("#777777"));
      int i = aekt.a(15.0F, paramaeov);
      int j = aekt.a(7.5F, paramaeov);
      paramContext = new RelativeLayout(paramContext);
      paramContext.setBackgroundResource(2130838186);
      paramContext.setPadding(i, j, i, j);
      paramContext.addView(paramBundle);
      paramContext.setId(2131377068);
      paramaeov = new RelativeLayout.LayoutParams(-2, -2);
      paramaeov.addRule(13);
      paramView.addView(paramContext, paramaeov);
      return paramView;
      paramView = new RelativeLayout(paramContext);
    }
  }
  
  public static View getInCompatibleView(Context paramContext, View paramView, String paramString)
  {
    if ((paramView != null) && ((paramView instanceof RelativeLayout))) {
      ((RelativeLayout)paramView).removeAllViews();
    }
    for (;;)
    {
      paramView = (RelativeLayout)paramView;
      paramContext = new TextView(paramContext);
      paramContext.setText(paramString);
      paramContext.setTextSize(2, 16.0F);
      paramContext.setTextColor(Color.parseColor("#000000"));
      int i = BaseChatItemLayout.n;
      int j = BaseChatItemLayout.o;
      paramView.setBackgroundResource(2130838186);
      paramContext.setPadding(i, BaseChatItemLayout.l, j, BaseChatItemLayout.m);
      paramView.addView(paramContext, new RelativeLayout.LayoutParams(-1, -1));
      return paramView;
      paramView = new RelativeLayout(paramContext);
    }
  }
  
  public static View getVersionExceptionView(Context paramContext, View paramView, aeov paramaeov, Bundle paramBundle)
  {
    return getExceptionView(paramContext, paramView, paramaeov, paramBundle, 2131698861);
  }
  
  public boolean LayoutEquals(Object paramObject)
  {
    return super.equals(paramObject);
  }
  
  public void addFlag(int paramInt)
  {
    if ((this.mFlag & paramInt) == paramInt) {
      return;
    }
    this.mFlag |= paramInt;
  }
  
  public abstract byte[] getBytes();
  
  public abstract View getPreDialogView(Context paramContext, View paramView);
  
  public abstract String getSourceName();
  
  public abstract View getSourceView(Context paramContext, View paramView);
  
  public View getView(Context paramContext, View paramView, aeov paramaeov, Bundle paramBundle)
  {
    paramaeov = paramView;
    if (paramView == null)
    {
      paramaeov = new LinearLayout(paramContext);
      paramaeov.setOrientation(1);
      paramContext = paramaeov.getLayoutParams();
      if (paramContext != null) {
        break label49;
      }
      paramContext = new LinearLayout.LayoutParams(BaseChatItemLayout.A, -2);
    }
    for (;;)
    {
      paramaeov.setLayoutParams(paramContext);
      return paramaeov;
      label49:
      paramContext.width = BaseChatItemLayout.A;
      paramContext.height = -2;
    }
  }
  
  public final String getXml()
  {
    Object localObject = new ByteArrayOutputStream();
    toXml((ByteArrayOutputStream)localObject, "UTF-8");
    try
    {
      localObject = ((ByteArrayOutputStream)localObject).toString("UTF-8");
      return localObject;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public final byte[] getXmlBytes()
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    toXml(localByteArrayOutputStream, "UTF-8");
    byte[] arrayOfByte;
    if (QLog.isDevelopLevel()) {
      arrayOfByte = null;
    }
    try
    {
      localObject = localByteArrayOutputStream.toString("UTF-8");
      QLog.d("StructMsg", 4, "Obj[" + System.identityHashCode(this) + "]getXmlBytes xmlStr:" + (String)localObject);
      localObject = azsd.b(localByteArrayOutputStream.toByteArray());
      int i = localObject.length;
      arrayOfByte = new byte[i + 1];
      arrayOfByte[0] = 1;
      System.arraycopy(localObject, 0, arrayOfByte, 1, i);
      return arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        Object localObject = arrayOfByte;
        if (QLog.isColorLevel())
        {
          QLog.d("StructMsg", 2, localUnsupportedEncodingException.getMessage(), localUnsupportedEncodingException);
          localObject = arrayOfByte;
        }
      }
    }
  }
  
  public boolean hasFlag(int paramInt)
  {
    return (this.mFlag & paramInt) == paramInt;
  }
  
  public boolean hasTSum()
  {
    return this.mTSum > 0;
  }
  
  protected void parseMsgAttrubutes(azsa paramazsa)
  {
    if (paramazsa == null) {}
    for (;;)
    {
      return;
      String str1 = paramazsa.a("templateID");
      if (!TextUtils.isEmpty(str1)) {
        this.mMsgTemplateID = Integer.parseInt(str1);
      }
      this.mMsgUrl = paramazsa.a("url");
      this.mMsgAction = paramazsa.a("action");
      this.mMsgActionData = paramazsa.a("actionData");
      this.mMsg_A_ActionData = paramazsa.a("a_actionData");
      this.mMsg_I_ActionData = paramazsa.a("i_actionData");
      this.rijAlbumActionData = paramazsa.a("rijAlbumActionData");
      this.mQzoneExtraMsg = paramazsa.a("qzFloatExtra");
      str1 = paramazsa.a("fwflag");
      if (!TextUtils.isEmpty(str1)) {}
      try
      {
        this.fwFlag = Integer.parseInt(str1);
        label128:
        str1 = paramazsa.a("flag");
        if (!TextUtils.isEmpty(str1)) {}
        try
        {
          this.mFlag = Integer.parseInt(str1);
          label151:
          str1 = paramazsa.a("serviceID");
          if (!TextUtils.isEmpty(str1)) {
            this.mMsgServiceID = Integer.parseInt(str1);
          }
          this.mMsgBrief = paramazsa.a("brief");
          this.mResid = paramazsa.a("m_resid");
          this.mFileName = paramazsa.a("m_fileName");
          str1 = paramazsa.a("tSum");
          if (!TextUtils.isEmpty(str1)) {
            this.mTSum = Integer.parseInt(str1);
          }
          str1 = paramazsa.a("m_fileSize");
          if (!TextUtils.isEmpty(str1)) {}
          try
          {
            this.mFileSize = Long.parseLong(str1);
            label253:
            str1 = paramazsa.a("promotionType");
            this.mPromotionMsg = paramazsa.a("promotionMsg");
            this.mPromotionMenus = paramazsa.a("promotionMenus");
            String str2 = paramazsa.a("promotionMenuDestructiveIndex");
            label392:
            label426:
            try
            {
              if (!TextUtils.isEmpty(str1)) {
                this.mPromotionType = Integer.parseInt(str1);
              }
              if (!TextUtils.isEmpty(str2)) {
                this.mPromotionMenuDestructiveIndex = Integer.parseInt(str2);
              }
            }
            catch (NumberFormatException localNumberFormatException4)
            {
              label321:
              label449:
              break label321;
            }
            this.source_puin = paramazsa.a("sourcePublicUin");
            if (this.source_puin == null) {
              this.source_puin = "";
            }
            this.mSourceThirdName = paramazsa.a("sourceName");
            if (this.mSourceThirdName == null) {
              this.mSourceThirdName = "";
            }
            str1 = paramazsa.a("sourceMsgId");
            try
            {
              if (!TextUtils.isEmpty(str1)) {
                this.msgId = Long.parseLong(str1);
              }
              this.mSType = paramazsa.a("sType");
              str1 = paramazsa.a("accostType");
              try
              {
                if (!TextUtils.isEmpty(str1)) {
                  this.sourceAccoutType = Integer.parseInt(str1);
                }
                str1 = paramazsa.a("adverSign");
                try
                {
                  if (!TextUtils.isEmpty(str1)) {
                    this.adverSign = Integer.parseInt(str1);
                  }
                  this.adverKey = paramazsa.a("adverKey");
                  this.index = paramazsa.a("index");
                  this.index_name = paramazsa.a("index_name");
                  this.index_type = paramazsa.a("index_type");
                  this.mExtraData = paramazsa.a("extraData");
                  this.mCreateTime = paramazsa.a("createTime");
                  this.mTagName = paramazsa.a("tagName");
                  this.mArticleIds = paramazsa.a("articleIds");
                  this.mOrangeWord = paramazsa.a("orangeWord");
                  this.mAlgorithmIds = paramazsa.a("algorithmIds");
                  this.mStrategyIds = paramazsa.a("strategyIds");
                  this.reportEventFolderStatusValue = paramazsa.a("reportEventFolderStatusValue");
                  this.mQidianBulkTaskId = paramazsa.a("qf_task_id");
                  this.mInnerUniqIds = paramazsa.a("uuids");
                  this.mQQStoryExtra = paramazsa.a("qqstoryExtra");
                  this.mTribeShortVideoExtra = paramazsa.a("qqtribeVideoInfoExtra");
                  this.mNeedRound = paramazsa.a("needRoundView");
                  this.mCommonData = paramazsa.a("msgCommonData");
                  this.mMergeSeq = paramazsa.a("mergeSeq");
                  paramazsa = paramazsa.a("sortKey");
                  try
                  {
                    if (!TextUtils.isEmpty(paramazsa)) {
                      this.mSortKey = Long.parseLong(paramazsa);
                    }
                    if (((this.mMsgServiceID != 142) && (this.mMsgServiceID != 500)) || (!TextUtils.isEmpty(this.mExtraData)) || (TextUtils.isEmpty(this.mMsgActionData))) {
                      continue;
                    }
                    try
                    {
                      this.mExtraData = new JSONObject(this.mMsgActionData).getString("push_ext_data");
                      return;
                    }
                    catch (Exception paramazsa)
                    {
                      paramazsa.getStackTrace();
                      return;
                    }
                  }
                  catch (NumberFormatException paramazsa)
                  {
                    for (;;)
                    {
                      paramazsa.printStackTrace();
                    }
                  }
                }
                catch (NumberFormatException localNumberFormatException1)
                {
                  break label449;
                }
              }
              catch (NumberFormatException localNumberFormatException2)
              {
                break label426;
              }
            }
            catch (NumberFormatException localNumberFormatException3)
            {
              break label392;
            }
          }
          catch (NumberFormatException localNumberFormatException5)
          {
            break label253;
          }
        }
        catch (NumberFormatException localNumberFormatException6)
        {
          break label151;
        }
      }
      catch (NumberFormatException localNumberFormatException7)
      {
        break label128;
      }
    }
  }
  
  public void removeFlag(int paramInt)
  {
    this.mFlag &= (paramInt ^ 0xFFFFFFFF);
  }
  
  public void setFlag(int paramInt)
  {
    this.mFlag = paramInt;
  }
  
  protected abstract void toXml(ByteArrayOutputStream paramByteArrayOutputStream, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.AbsStructMsg
 * JD-Core Version:    0.7.0.1
 */