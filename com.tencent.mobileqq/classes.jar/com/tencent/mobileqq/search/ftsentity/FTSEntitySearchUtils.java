package com.tencent.mobileqq.search.ftsentity;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.fts.FTSMessage;
import com.tencent.mobileqq.persistence.fts.FTSEntity;
import com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine;
import com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchResultDetailModel;
import com.tencent.mobileqq.search.searchengine.SearchRequest;
import java.util.ArrayList;

public class FTSEntitySearchUtils
{
  public static FTSEntitySearchEngine a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    return new FTSMessageSearchEngine(paramQQAppInterface);
  }
  
  public static FTSEntitySearchResultDetailModel a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, ArrayList paramArrayList, FTSEntity paramFTSEntity)
  {
    return new FTSMessageSearchResultDetailModel(paramQQAppInterface, paramString, paramArrayList, paramFTSEntity);
  }
  
  public static SearchRequest a(int paramInt, String paramString, FTSEntity paramFTSEntity)
  {
    paramString = new SearchRequest(paramString);
    paramFTSEntity = (FTSMessage)paramFTSEntity;
    paramString.a = new Bundle();
    paramString.a.putLong("uin", paramFTSEntity.uin);
    paramString.a.putInt("uinType", paramFTSEntity.istroop);
    return paramString;
  }
  
  public static String a(Context paramContext, int paramInt)
  {
    return paramContext.getString(2131438129);
  }
  
  public static String a(Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    String str = paramString;
    if (paramString.length() > 13) {
      str = paramString.substring(0, 10) + "…";
    }
    return paramContext.getString(2131438128, new Object[] { Integer.valueOf(paramInt1), str });
  }
  
  public static String b(Context paramContext, int paramInt)
  {
    return "搜索聊天记录";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsentity.FTSEntitySearchUtils
 * JD-Core Version:    0.7.0.1
 */