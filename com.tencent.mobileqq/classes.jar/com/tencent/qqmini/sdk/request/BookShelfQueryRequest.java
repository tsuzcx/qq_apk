package com.tencent.qqmini.sdk.request;

import NS_MINI_BOOK_SHELF.MiniBookShelf.Information;
import NS_MINI_BOOK_SHELF.MiniBookShelf.StQueryBookShelfReq;
import NS_MINI_BOOK_SHELF.MiniBookShelf.StQueryBookShelfRsp;
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

public class BookShelfQueryRequest
  extends ProtoBufRequest
{
  public static final String TAG = "BookShelfQueryRequest";
  private MiniBookShelf.StQueryBookShelfReq req = new MiniBookShelf.StQueryBookShelfReq();
  
  public BookShelfQueryRequest(String paramString, ArrayList<String> paramArrayList)
  {
    this.req.appid.set(paramString);
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
    return "QueryBookShelf";
  }
  
  protected String getModule()
  {
    return "mini_book_shelf";
  }
  
  public JSONObject getResponse(byte[] paramArrayOfByte, JSONObject paramJSONObject)
  {
    if (paramArrayOfByte == null) {
      paramArrayOfByte = null;
    }
    for (;;)
    {
      return paramArrayOfByte;
      try
      {
        Object localObject = new MiniBookShelf.StQueryBookShelfRsp();
        ((MiniBookShelf.StQueryBookShelfRsp)localObject).mergeFrom(paramArrayOfByte);
        localObject = ((MiniBookShelf.StQueryBookShelfRsp)localObject).bookInfo.get();
        paramArrayOfByte = paramJSONObject;
        if (localObject != null)
        {
          paramArrayOfByte = paramJSONObject;
          if (((List)localObject).size() > 0)
          {
            paramArrayOfByte = new JSONArray();
            int i = 0;
            for (;;)
            {
              int j = ((List)localObject).size();
              if (i < j) {
                try
                {
                  JSONObject localJSONObject = new JSONObject();
                  localJSONObject.putOpt("contendId", ((MiniBookShelf.Information)((List)localObject).get(i)).contentId.get());
                  localJSONObject.putOpt("status", Integer.valueOf(((MiniBookShelf.Information)((List)localObject).get(i)).status.get()));
                  localJSONObject.putOpt("msg", ((MiniBookShelf.Information)((List)localObject).get(i)).msg.get());
                  localJSONObject.putOpt("exist", Integer.valueOf(((MiniBookShelf.Information)((List)localObject).get(i)).existStatus.get()));
                  paramArrayOfByte.put(localJSONObject);
                  i += 1;
                }
                catch (Throwable localThrowable)
                {
                  for (;;)
                  {
                    QMLog.i("BookShelfQueryRequest", "", localThrowable);
                  }
                }
              }
            }
            paramJSONObject.putOpt("data", paramArrayOfByte);
          }
        }
      }
      catch (Exception paramArrayOfByte)
      {
        QMLog.e("BookShelfQueryRequest", "onResponse fail." + paramArrayOfByte);
        return null;
      }
    }
    return paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.BookShelfQueryRequest
 * JD-Core Version:    0.7.0.1
 */