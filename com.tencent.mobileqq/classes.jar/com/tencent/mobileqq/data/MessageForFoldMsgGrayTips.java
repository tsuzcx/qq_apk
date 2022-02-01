package com.tencent.mobileqq.data;

import amtj;
import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import aqqz;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class MessageForFoldMsgGrayTips
  extends ChatMessage
{
  public static int PASSWD_REDBAG_FOLD_NICK_NUM = 20;
  public static int PASSWD_REDBAG_FOLD_STORE_NICK_LEN = 20;
  public static int PASSWD_REDBAG_MSG_DISPLAY_NUM_DEFAULT;
  public static boolean PASSWD_REDBAG_MSG_INDEX_WITH_ID;
  public static boolean PASSWD_REDBAG_MSG_SWITCH_DEFAULT = true;
  public static boolean PASSWD_REDBAG_MSG_SWITCH_INDEX;
  private SpannableString clickSpan;
  public int foldMsgCount;
  public LinkedHashSet<String> foldUinList = new LinkedHashSet();
  ArrayList<String> foldUinNickList = new ArrayList();
  public boolean isOpen = true;
  public String redBagId;
  public String redBagIndex;
  public String redBagSenderNick;
  public String redBagSenderUin;
  
  static
  {
    PASSWD_REDBAG_MSG_DISPLAY_NUM_DEFAULT = 10;
    PASSWD_REDBAG_MSG_SWITCH_INDEX = true;
    PASSWD_REDBAG_MSG_INDEX_WITH_ID = true;
  }
  
  protected void doParse() {}
  
  public CharSequence getShowMsgContent(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    int i = (int)Long.parseLong("E62555", 16);
    if (this.clickSpan == null)
    {
      this.clickSpan = new SpannableString(amtj.a(2131705703));
      this.clickSpan.setSpan(new aqqz(this, paramQQAppInterface, paramContext, i | 0xFF000000), 0, this.clickSpan.length(), 33);
    }
    this.msg = "";
    paramQQAppInterface = new SpannableStringBuilder();
    if (!this.isOpen)
    {
      paramQQAppInterface.append(String.format("此处省略%d条抢%s", new Object[] { Integer.valueOf(this.foldMsgCount), this.redBagSenderNick }));
      paramQQAppInterface.append(this.clickSpan);
      paramQQAppInterface.append("的口令");
      return paramQQAppInterface;
    }
    paramContext = new StringBuilder();
    int j = Math.min(this.foldUinNickList.size(), PASSWD_REDBAG_FOLD_NICK_NUM);
    i = 0;
    while (i < j)
    {
      int k = this.foldUinNickList.size();
      paramContext.append((String)this.foldUinNickList.get(k - 1 - i));
      if (i != j - 1) {
        paramContext.append("、");
      }
      i += 1;
    }
    if (j >= PASSWD_REDBAG_FOLD_NICK_NUM)
    {
      paramContext.append("等");
      paramContext.append(this.foldUinList.size()).append("人");
    }
    paramContext.append("也抢了").append(this.redBagSenderNick).append("发的");
    paramQQAppInterface.append(paramContext);
    paramQQAppInterface.append(this.clickSpan);
    return paramQQAppInterface;
  }
  
  public void init(QQAppInterface paramQQAppInterface, String paramString1, long paramLong, LinkedHashSet<String> paramLinkedHashSet, String paramString2, String paramString3)
  {
    this.redBagId = paramString2;
    this.redBagIndex = paramString3;
    this.redBagSenderUin = String.valueOf(paramLong);
    this.redBagSenderNick = ContactUtils.getGrayBarShowName(paramQQAppInterface, paramString1, this.redBagSenderUin);
    this.foldUinList = paramLinkedHashSet;
    if (!paramLinkedHashSet.isEmpty())
    {
      paramString3 = this.foldUinList.iterator();
      while (paramString3.hasNext())
      {
        paramString2 = ContactUtils.getGrayBarShowName(paramQQAppInterface, paramString1, (String)paramString3.next());
        paramLinkedHashSet = paramString2;
        if (paramString2.length() > PASSWD_REDBAG_FOLD_STORE_NICK_LEN) {
          paramLinkedHashSet = paramString2.substring(0, PASSWD_REDBAG_FOLD_STORE_NICK_LEN) + "...";
        }
        this.foldUinNickList.add(paramLinkedHashSet);
      }
    }
  }
  
  public void update(QQAppInterface paramQQAppInterface, String paramString1, LinkedHashSet<String> paramLinkedHashSet, int paramInt, String paramString2, String paramString3)
  {
    this.foldMsgCount += paramInt;
    if (!TextUtils.isEmpty(paramString2)) {
      this.redBagId = paramString2;
    }
    if (!TextUtils.isEmpty(paramString3)) {
      this.redBagIndex = paramString3;
    }
    paramString3 = paramLinkedHashSet.iterator();
    while (paramString3.hasNext())
    {
      paramLinkedHashSet = (String)paramString3.next();
      if ((this.foldUinList.add(paramLinkedHashSet)) && (this.foldUinNickList.size() < PASSWD_REDBAG_FOLD_NICK_NUM))
      {
        paramString2 = ContactUtils.getGrayBarShowName(paramQQAppInterface, paramString1, paramLinkedHashSet);
        paramLinkedHashSet = paramString2;
        if (paramString2.length() > PASSWD_REDBAG_FOLD_STORE_NICK_LEN) {
          paramLinkedHashSet = paramString2.substring(0, PASSWD_REDBAG_FOLD_STORE_NICK_LEN) + "...";
        }
        this.foldUinNickList.add(paramLinkedHashSet);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForFoldMsgGrayTips
 * JD-Core Version:    0.7.0.1
 */