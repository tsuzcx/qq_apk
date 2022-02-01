package com.tencent.qqmini.sdk.request;

import NS_MINI_BOOK_SHELF.MiniBookShelf.Information;
import NS_MINI_BOOK_SHELF.MiniBookShelf.StInsertBookShelfReq;
import NS_MINI_BOOK_SHELF.MiniBookShelf.StInsertBookShelfRsp;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class BookShelfInsertRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_book_shelf.InsertBookShelf";
  public static final String KEY_RESULT_DATA = "key_result_data";
  public static final String TAG = "BookShelfInsertRequest";
  private MiniBookShelf.StInsertBookShelfReq req = new MiniBookShelf.StInsertBookShelfReq();
  
  public BookShelfInsertRequest(String paramString1, String paramString2, ArrayList<String> paramArrayList)
  {
    this.req.appid.set(paramString1);
    this.req.category.set(paramString2);
    if (paramArrayList != null) {
      this.req.contentIds.addAll(paramArrayList);
    }
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
  
  protected String getCmdName()
  {
    return "InsertBookShelf";
  }
  
  public String getCmdString()
  {
    return "LightAppSvc.mini_book_shelf.InsertBookShelf";
  }
  
  protected String getModule()
  {
    return "mini_book_shelf";
  }
  
  public JSONObject getResponse(byte[] paramArrayOfByte, JSONObject paramJSONObject)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    for (;;)
    {
      int i;
      try
      {
        Object localObject = new MiniBookShelf.StInsertBookShelfRsp();
        ((MiniBookShelf.StInsertBookShelfRsp)localObject).mergeFrom(paramArrayOfByte);
        paramArrayOfByte = ((MiniBookShelf.StInsertBookShelfRsp)localObject).info.get();
        if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0))
        {
          localObject = new JSONArray();
          i = 0;
          int j = paramArrayOfByte.size();
          if (i < j) {
            try
            {
              JSONObject localJSONObject = new JSONObject();
              localJSONObject.putOpt("contendId", ((MiniBookShelf.Information)paramArrayOfByte.get(i)).contentId.get());
              localJSONObject.putOpt("status", Integer.valueOf(((MiniBookShelf.Information)paramArrayOfByte.get(i)).status.get()));
              localJSONObject.putOpt("msg", ((MiniBookShelf.Information)paramArrayOfByte.get(i)).msg.get());
              localJSONObject.putOpt("exist", Integer.valueOf(((MiniBookShelf.Information)paramArrayOfByte.get(i)).existStatus.get()));
              ((JSONArray)localObject).put(localJSONObject);
            }
            catch (Throwable localThrowable)
            {
              QMLog.i("BookShelfInsertRequest", "", localThrowable);
            }
          } else {
            paramJSONObject.putOpt("key_result_data", localObject);
          }
        }
        else
        {
          return paramJSONObject;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("onResponse fail.");
        paramJSONObject.append(paramArrayOfByte);
        QMLog.e("BookShelfInsertRequest", paramJSONObject.toString());
        return null;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.BookShelfInsertRequest
 * JD-Core Version:    0.7.0.1
 */