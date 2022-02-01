package com.tencent.mobileqq.search.ftsentity;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fts.data.msg.FTSMessage;
import com.tencent.mobileqq.fts.v1.FTSEntity;
import com.tencent.mobileqq.search.base.model.SearchRequest;
import com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine;
import com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchResultDetailModel;
import com.tencent.mobileqq.search.ftsmsg.FTSTempGameMsgSearchResultDetailModel;
import java.util.ArrayList;

public class FTSEntitySearchUtils
{
  public static SearchRequest a(int paramInt, String paramString, FTSEntity paramFTSEntity)
  {
    paramString = new SearchRequest(paramString);
    paramFTSEntity = (FTSMessage)paramFTSEntity;
    paramString.b = new Bundle();
    paramString.b.putLong("uin", paramFTSEntity.uin);
    paramString.b.putInt("uinType", paramFTSEntity.istroop);
    return paramString;
  }
  
  public static FTSEntitySearchEngine a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    return new FTSMessageSearchEngine(paramQQAppInterface);
  }
  
  public static FTSEntitySearchResultDetailModel a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, ArrayList<String> paramArrayList, FTSEntity paramFTSEntity)
  {
    if (((paramFTSEntity instanceof FTSMessage)) && (((FTSMessage)paramFTSEntity).istroop == 10007)) {
      return new FTSTempGameMsgSearchResultDetailModel(paramQQAppInterface, paramString, paramArrayList, paramFTSEntity);
    }
    return new FTSMessageSearchResultDetailModel(paramQQAppInterface, paramString, paramArrayList, paramFTSEntity);
  }
  
  public static String a(Context paramContext, int paramInt)
  {
    return paramContext.getString(2131916109);
  }
  
  public static String a(Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    Object localObject = paramString;
    if (paramString.length() > 13)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString.substring(0, 10));
      ((StringBuilder)localObject).append("…");
      localObject = ((StringBuilder)localObject).toString();
    }
    return paramContext.getString(2131916108, new Object[] { Integer.valueOf(paramInt1), localObject });
  }
  
  public static String b(Context paramContext, int paramInt)
  {
    return HardCodeUtil.a(2131902939);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsentity.FTSEntitySearchUtils
 * JD-Core Version:    0.7.0.1
 */