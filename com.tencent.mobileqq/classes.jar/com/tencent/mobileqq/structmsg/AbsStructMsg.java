package com.tencent.mobileqq.structmsg;

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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.Externalizable;
import java.io.UnsupportedEncodingException;

public abstract class AbsStructMsg
  implements StructMsgConstants, Externalizable
{
  public static final String DEFAULT_MSG_BRIEF = "应用分享";
  public static final String PA_DEFAULT_MSG_BRIEF = "你有新消息";
  public static int SOURCE_ACCOUNT_TYPE_PA = 7;
  public String adverKey;
  public int adverSign;
  public String currentAccountUin;
  public int dynamicMsgMergeIndex = -1;
  public String dynamicMsgMergeKey = "";
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
  int mFlag;
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
  public String mTagName;
  public String mTribeShortVideoExtra;
  int mVersion = 1;
  public MessageRecord message;
  public int messageVersion;
  public long msgId;
  public int multiMsgFlag;
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
  
  AbsStructMsg(StructMsgNode paramStructMsgNode)
  {
    parseMsgAttrubutes(paramStructMsgNode);
  }
  
  public static View getExceptionView(Context paramContext, View paramView, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, Bundle paramBundle, int paramInt)
  {
    return getExceptionView(paramContext, paramView, paramOnLongClickAndTouchListener, paramBundle, paramContext.getResources().getString(paramInt));
  }
  
  public static View getExceptionView(Context paramContext, View paramView, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, Bundle paramBundle, String paramString)
  {
    paramOnLongClickAndTouchListener = paramContext.getResources();
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
      int i = AIOUtils.a(15.0F, paramOnLongClickAndTouchListener);
      int j = AIOUtils.a(7.5F, paramOnLongClickAndTouchListener);
      paramContext = new RelativeLayout(paramContext);
      paramContext.setBackgroundResource(2130837916);
      paramContext.setPadding(i, j, i, j);
      paramContext.addView(paramBundle);
      paramContext.setId(2131362099);
      paramOnLongClickAndTouchListener = new RelativeLayout.LayoutParams(-2, -2);
      paramOnLongClickAndTouchListener.addRule(13);
      paramView.addView(paramContext, paramOnLongClickAndTouchListener);
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
      paramView.setBackgroundResource(2130837916);
      paramContext.setPadding(i, BaseChatItemLayout.l, j, BaseChatItemLayout.m);
      paramView.addView(paramContext, new RelativeLayout.LayoutParams(-1, -1));
      return paramView;
      paramView = new RelativeLayout(paramContext);
    }
  }
  
  public static View getVersionExceptionView(Context paramContext, View paramView, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, Bundle paramBundle)
  {
    return getExceptionView(paramContext, paramView, paramOnLongClickAndTouchListener, paramBundle, 2131433426);
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
  
  public View getView(Context paramContext, View paramView, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, Bundle paramBundle)
  {
    paramOnLongClickAndTouchListener = paramView;
    if (paramView == null)
    {
      paramOnLongClickAndTouchListener = new LinearLayout(paramContext);
      paramOnLongClickAndTouchListener.setOrientation(1);
      paramContext = paramOnLongClickAndTouchListener.getLayoutParams();
      if (paramContext != null) {
        break label49;
      }
      paramContext = new LinearLayout.LayoutParams(BaseChatItemLayout.e, -2);
    }
    for (;;)
    {
      paramOnLongClickAndTouchListener.setLayoutParams(paramContext);
      return paramOnLongClickAndTouchListener;
      label49:
      paramContext.width = BaseChatItemLayout.e;
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
      QLog.d("StructMsg", 4, "getXmlBytes xmlStr:" + (String)localObject);
      localObject = StructMsgUtils.b(localByteArrayOutputStream.toByteArray());
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
  
  protected void parseMsgAttrubutes(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {}
    for (;;)
    {
      return;
      String str1 = paramStructMsgNode.a("templateID");
      if (!TextUtils.isEmpty(str1)) {
        this.mMsgTemplateID = Integer.parseInt(str1);
      }
      this.mMsgUrl = paramStructMsgNode.a("url");
      this.mMsgAction = paramStructMsgNode.a("action");
      this.mMsgActionData = paramStructMsgNode.a("actionData");
      this.mMsg_A_ActionData = paramStructMsgNode.a("a_actionData");
      this.mMsg_I_ActionData = paramStructMsgNode.a("i_actionData");
      this.rijAlbumActionData = paramStructMsgNode.a("rijAlbumActionData");
      str1 = paramStructMsgNode.a("fwflag");
      if (!TextUtils.isEmpty(str1)) {}
      try
      {
        this.fwFlag = Integer.parseInt(str1);
        label117:
        str1 = paramStructMsgNode.a("flag");
        if (!TextUtils.isEmpty(str1)) {}
        try
        {
          this.mFlag = Integer.parseInt(str1);
          label140:
          str1 = paramStructMsgNode.a("serviceID");
          if (!TextUtils.isEmpty(str1)) {
            this.mMsgServiceID = Integer.parseInt(str1);
          }
          this.mMsgBrief = paramStructMsgNode.a("brief");
          this.mResid = paramStructMsgNode.a("m_resid");
          this.mFileName = paramStructMsgNode.a("m_fileName");
          str1 = paramStructMsgNode.a("m_fileSize");
          if (!TextUtils.isEmpty(str1)) {}
          try
          {
            this.mFileSize = Long.parseLong(str1);
            label219:
            str1 = paramStructMsgNode.a("promotionType");
            this.mPromotionMsg = paramStructMsgNode.a("promotionMsg");
            this.mPromotionMenus = paramStructMsgNode.a("promotionMenus");
            String str2 = paramStructMsgNode.a("promotionMenuDestructiveIndex");
            label287:
            label415:
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
              label358:
              break label287;
            }
            this.source_puin = paramStructMsgNode.a("sourcePublicUin");
            if (this.source_puin == null) {
              this.source_puin = "";
            }
            this.mSourceThirdName = paramStructMsgNode.a("sourceName");
            if (this.mSourceThirdName == null) {
              this.mSourceThirdName = "";
            }
            str1 = paramStructMsgNode.a("sourceMsgId");
            try
            {
              if (!TextUtils.isEmpty(str1)) {
                this.msgId = Long.parseLong(str1);
              }
              this.mSType = paramStructMsgNode.a("sType");
              str1 = paramStructMsgNode.a("accostType");
              try
              {
                if (!TextUtils.isEmpty(str1)) {
                  this.sourceAccoutType = Integer.parseInt(str1);
                }
                label392:
                str1 = paramStructMsgNode.a("adverSign");
                try
                {
                  if (!TextUtils.isEmpty(str1)) {
                    this.adverSign = Integer.parseInt(str1);
                  }
                  this.adverKey = paramStructMsgNode.a("adverKey");
                  this.index = paramStructMsgNode.a("index");
                  this.index_name = paramStructMsgNode.a("index_name");
                  this.index_type = paramStructMsgNode.a("index_type");
                  this.mExtraData = paramStructMsgNode.a("extraData");
                  this.mCreateTime = paramStructMsgNode.a("createTime");
                  this.mTagName = paramStructMsgNode.a("tagName");
                  this.mArticleIds = paramStructMsgNode.a("articleIds");
                  this.mOrangeWord = paramStructMsgNode.a("orangeWord");
                  this.mAlgorithmIds = paramStructMsgNode.a("algorithmIds");
                  this.mStrategyIds = paramStructMsgNode.a("strategyIds");
                  this.reportEventFolderStatusValue = paramStructMsgNode.a("reportEventFolderStatusValue");
                  this.mQidianBulkTaskId = paramStructMsgNode.a("qf_task_id");
                  this.mInnerUniqIds = paramStructMsgNode.a("uuids");
                  this.mQQStoryExtra = paramStructMsgNode.a("qqstoryExtra");
                  this.mTribeShortVideoExtra = paramStructMsgNode.a("qqtribeVideoInfoExtra");
                  this.mNeedRound = paramStructMsgNode.a("needRoundView");
                  this.mCommonData = paramStructMsgNode.a("msgCommonData");
                  this.mMergeSeq = paramStructMsgNode.a("mergeSeq");
                  paramStructMsgNode = paramStructMsgNode.a("sortKey");
                  try
                  {
                    if (TextUtils.isEmpty(paramStructMsgNode)) {
                      continue;
                    }
                    this.mSortKey = Long.parseLong(paramStructMsgNode);
                    return;
                  }
                  catch (NumberFormatException paramStructMsgNode)
                  {
                    paramStructMsgNode.printStackTrace();
                    return;
                  }
                }
                catch (NumberFormatException localNumberFormatException1)
                {
                  break label415;
                }
              }
              catch (NumberFormatException localNumberFormatException2)
              {
                break label392;
              }
            }
            catch (NumberFormatException localNumberFormatException3)
            {
              break label358;
            }
          }
          catch (NumberFormatException localNumberFormatException5)
          {
            break label219;
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
  
  public abstract void toXml(ByteArrayOutputStream paramByteArrayOutputStream, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.AbsStructMsg
 * JD-Core Version:    0.7.0.1
 */