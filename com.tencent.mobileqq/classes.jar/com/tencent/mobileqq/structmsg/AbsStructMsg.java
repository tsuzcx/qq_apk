package com.tencent.mobileqq.structmsg;

import actn;
import acxn;
import ajyc;
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
import axuw;
import axwe;
import axwh;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.Externalizable;
import java.io.UnsupportedEncodingException;
import org.json.JSONObject;

public abstract class AbsStructMsg
  implements axuw, Externalizable
{
  public static final String DEFAULT_MSG_BRIEF = ajyc.a(2131699714);
  public static final String PA_DEFAULT_MSG_BRIEF = ajyc.a(2131699713);
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
  
  AbsStructMsg(axwe paramaxwe)
  {
    parseMsgAttrubutes(paramaxwe);
  }
  
  public static View getExceptionView(Context paramContext, View paramView, acxn paramacxn, Bundle paramBundle, int paramInt)
  {
    return getExceptionView(paramContext, paramView, paramacxn, paramBundle, paramContext.getResources().getString(paramInt));
  }
  
  public static View getExceptionView(Context paramContext, View paramView, acxn paramacxn, Bundle paramBundle, String paramString)
  {
    paramacxn = paramContext.getResources();
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
      int i = actn.a(15.0F, paramacxn);
      int j = actn.a(7.5F, paramacxn);
      paramContext = new RelativeLayout(paramContext);
      paramContext.setBackgroundResource(2130838130);
      paramContext.setPadding(i, j, i, j);
      paramContext.addView(paramBundle);
      paramContext.setId(2131376566);
      paramacxn = new RelativeLayout.LayoutParams(-2, -2);
      paramacxn.addRule(13);
      paramView.addView(paramContext, paramacxn);
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
      paramView.setBackgroundResource(2130838130);
      paramContext.setPadding(i, BaseChatItemLayout.l, j, BaseChatItemLayout.m);
      paramView.addView(paramContext, new RelativeLayout.LayoutParams(-1, -1));
      return paramView;
      paramView = new RelativeLayout(paramContext);
    }
  }
  
  public static View getVersionExceptionView(Context paramContext, View paramView, acxn paramacxn, Bundle paramBundle)
  {
    return getExceptionView(paramContext, paramView, paramacxn, paramBundle, 2131698555);
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
  
  public View getView(Context paramContext, View paramView, acxn paramacxn, Bundle paramBundle)
  {
    paramacxn = paramView;
    if (paramView == null)
    {
      paramacxn = new LinearLayout(paramContext);
      paramacxn.setOrientation(1);
      paramContext = paramacxn.getLayoutParams();
      if (paramContext != null) {
        break label49;
      }
      paramContext = new LinearLayout.LayoutParams(BaseChatItemLayout.A, -2);
    }
    for (;;)
    {
      paramacxn.setLayoutParams(paramContext);
      return paramacxn;
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
      localObject = axwh.b(localByteArrayOutputStream.toByteArray());
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
  
  protected void parseMsgAttrubutes(axwe paramaxwe)
  {
    if (paramaxwe == null) {}
    for (;;)
    {
      return;
      String str1 = paramaxwe.a("templateID");
      if (!TextUtils.isEmpty(str1)) {
        this.mMsgTemplateID = Integer.parseInt(str1);
      }
      this.mMsgUrl = paramaxwe.a("url");
      this.mMsgAction = paramaxwe.a("action");
      this.mMsgActionData = paramaxwe.a("actionData");
      this.mMsg_A_ActionData = paramaxwe.a("a_actionData");
      this.mMsg_I_ActionData = paramaxwe.a("i_actionData");
      this.rijAlbumActionData = paramaxwe.a("rijAlbumActionData");
      str1 = paramaxwe.a("fwflag");
      if (!TextUtils.isEmpty(str1)) {}
      try
      {
        this.fwFlag = Integer.parseInt(str1);
        label117:
        str1 = paramaxwe.a("flag");
        if (!TextUtils.isEmpty(str1)) {}
        try
        {
          this.mFlag = Integer.parseInt(str1);
          label140:
          str1 = paramaxwe.a("serviceID");
          if (!TextUtils.isEmpty(str1)) {
            this.mMsgServiceID = Integer.parseInt(str1);
          }
          this.mMsgBrief = paramaxwe.a("brief");
          this.mResid = paramaxwe.a("m_resid");
          this.mFileName = paramaxwe.a("m_fileName");
          str1 = paramaxwe.a("tSum");
          if (!TextUtils.isEmpty(str1)) {
            this.mTSum = Integer.parseInt(str1);
          }
          str1 = paramaxwe.a("m_fileSize");
          if (!TextUtils.isEmpty(str1)) {}
          try
          {
            this.mFileSize = Long.parseLong(str1);
            label242:
            str1 = paramaxwe.a("promotionType");
            this.mPromotionMsg = paramaxwe.a("promotionMsg");
            this.mPromotionMenus = paramaxwe.a("promotionMenus");
            String str2 = paramaxwe.a("promotionMenuDestructiveIndex");
            label310:
            label438:
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
              label381:
              break label310;
            }
            this.source_puin = paramaxwe.a("sourcePublicUin");
            if (this.source_puin == null) {
              this.source_puin = "";
            }
            this.mSourceThirdName = paramaxwe.a("sourceName");
            if (this.mSourceThirdName == null) {
              this.mSourceThirdName = "";
            }
            str1 = paramaxwe.a("sourceMsgId");
            try
            {
              if (!TextUtils.isEmpty(str1)) {
                this.msgId = Long.parseLong(str1);
              }
              this.mSType = paramaxwe.a("sType");
              str1 = paramaxwe.a("accostType");
              try
              {
                if (!TextUtils.isEmpty(str1)) {
                  this.sourceAccoutType = Integer.parseInt(str1);
                }
                label415:
                str1 = paramaxwe.a("adverSign");
                try
                {
                  if (!TextUtils.isEmpty(str1)) {
                    this.adverSign = Integer.parseInt(str1);
                  }
                  this.adverKey = paramaxwe.a("adverKey");
                  this.index = paramaxwe.a("index");
                  this.index_name = paramaxwe.a("index_name");
                  this.index_type = paramaxwe.a("index_type");
                  this.mExtraData = paramaxwe.a("extraData");
                  this.mCreateTime = paramaxwe.a("createTime");
                  this.mTagName = paramaxwe.a("tagName");
                  this.mArticleIds = paramaxwe.a("articleIds");
                  this.mOrangeWord = paramaxwe.a("orangeWord");
                  this.mAlgorithmIds = paramaxwe.a("algorithmIds");
                  this.mStrategyIds = paramaxwe.a("strategyIds");
                  this.reportEventFolderStatusValue = paramaxwe.a("reportEventFolderStatusValue");
                  this.mQidianBulkTaskId = paramaxwe.a("qf_task_id");
                  this.mInnerUniqIds = paramaxwe.a("uuids");
                  this.mQQStoryExtra = paramaxwe.a("qqstoryExtra");
                  this.mTribeShortVideoExtra = paramaxwe.a("qqtribeVideoInfoExtra");
                  this.mNeedRound = paramaxwe.a("needRoundView");
                  this.mCommonData = paramaxwe.a("msgCommonData");
                  this.mMergeSeq = paramaxwe.a("mergeSeq");
                  paramaxwe = paramaxwe.a("sortKey");
                  try
                  {
                    if (!TextUtils.isEmpty(paramaxwe)) {
                      this.mSortKey = Long.parseLong(paramaxwe);
                    }
                    if (((this.mMsgServiceID != 142) && (this.mMsgServiceID != 500)) || (!TextUtils.isEmpty(this.mExtraData)) || (TextUtils.isEmpty(this.mMsgActionData))) {
                      continue;
                    }
                    try
                    {
                      this.mExtraData = new JSONObject(this.mMsgActionData).getString("push_ext_data");
                      return;
                    }
                    catch (Exception paramaxwe)
                    {
                      paramaxwe.getStackTrace();
                      return;
                    }
                  }
                  catch (NumberFormatException paramaxwe)
                  {
                    for (;;)
                    {
                      paramaxwe.printStackTrace();
                    }
                  }
                }
                catch (NumberFormatException localNumberFormatException1)
                {
                  break label438;
                }
              }
              catch (NumberFormatException localNumberFormatException2)
              {
                break label415;
              }
            }
            catch (NumberFormatException localNumberFormatException3)
            {
              break label381;
            }
          }
          catch (NumberFormatException localNumberFormatException5)
          {
            break label242;
          }
        }
        catch (NumberFormatException localNumberFormatException6)
        {
          break label140;
        }
      }
      catch (NumberFormatException localNumberFormatException7)
      {
        break label117;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.AbsStructMsg
 * JD-Core Version:    0.7.0.1
 */