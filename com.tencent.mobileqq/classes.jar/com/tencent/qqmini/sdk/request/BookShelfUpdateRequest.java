package com.tencent.qqmini.sdk.request;

import NS_MINI_BOOK_SHELF.MiniBookShelf.Information;
import NS_MINI_BOOK_SHELF.MiniBookShelf.StUpdateBookShelfReadTimeReq;
import NS_MINI_BOOK_SHELF.MiniBookShelf.StUpdateBookShelfReadTimeRsp;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

public class BookShelfUpdateRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_book_shelf.UpdateBookShelfReadTime";
  public static final String KEY_RESULT_DATA = "key_result_data";
  public static final String TAG = "BookShelfUpdateRequest";
  private MiniBookShelf.StUpdateBookShelfReadTimeReq req = new MiniBookShelf.StUpdateBookShelfReadTimeReq();
  
  public BookShelfUpdateRequest(String paramString1, String paramString2, String paramString3)
  {
    this.req.appid.set(paramString1);
    this.req.category.set(paramString2);
    this.req.contentId.set(paramString3);
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
  
  protected String getCmdName()
  {
    return "UpdateBookShelfReadTime";
  }
  
  public String getCmdString()
  {
    return "LightAppSvc.mini_book_shelf.UpdateBookShelfReadTime";
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
    try
    {
      Object localObject = new MiniBookShelf.StUpdateBookShelfReadTimeRsp();
      ((MiniBookShelf.StUpdateBookShelfReadTimeRsp)localObject).mergeFrom(paramArrayOfByte);
      localObject = (MiniBookShelf.Information)((MiniBookShelf.StUpdateBookShelfReadTimeRsp)localObject).updateInfo.get();
      if (localObject != null)
      {
        paramArrayOfByte = new JSONObject();
        try
        {
          paramArrayOfByte.putOpt("contendId", ((MiniBookShelf.Information)localObject).contentId.get());
          paramArrayOfByte.putOpt("status", Integer.valueOf(((MiniBookShelf.Information)localObject).status.get()));
          paramArrayOfByte.putOpt("msg", ((MiniBookShelf.Information)localObject).msg.get());
          paramArrayOfByte.putOpt("exist", Integer.valueOf(((MiniBookShelf.Information)localObject).existStatus.get()));
        }
        catch (Throwable localThrowable)
        {
          QMLog.i("BookShelfUpdateRequest", "", localThrowable);
        }
        paramJSONObject.putOpt("key_result_data", paramArrayOfByte);
      }
      return paramJSONObject;
    }
    catch (Exception paramArrayOfByte)
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("onResponse fail.");
      paramJSONObject.append(paramArrayOfByte);
      QMLog.e("BookShelfUpdateRequest", paramJSONObject.toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.BookShelfUpdateRequest
 * JD-Core Version:    0.7.0.1
 */