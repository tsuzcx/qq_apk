package com.tencent.mobileqq.mini.servlet;

import NS_MINI_BOOK_SHELF.MiniBookShelf.Information;
import NS_MINI_BOOK_SHELF.MiniBookShelf.StUpdateBookShelfReadTimeRsp;
import android.content.Intent;
import android.os.Bundle;
import bgau;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;
import org.json.JSONObject;

public class BookShelfUpdateServlet
  extends MiniAppAbstractServlet
{
  public static final String KEY_APPID = "key_appid";
  public static final String KEY_CATEGORY = "key_category";
  public static final String KEY_CONTENT_ID = "key_contentId";
  public static final String KEY_RESULT_DATA = "key_result_data";
  public static final String TAG = "BookShelfUpdateServlet";
  
  public BookShelfUpdateServlet()
  {
    this.observerId = 1082;
  }
  
  public void onProcessData(Intent paramIntent, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = BookShelfUpdateRequest.onResponse(paramArrayOfByte);
    if (paramArrayOfByte != null) {
      paramArrayOfByte = (MiniBookShelf.Information)paramArrayOfByte.updateInfo.get();
    }
    for (;;)
    {
      if (paramArrayOfByte != null)
      {
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.putOpt("contendId", paramArrayOfByte.contentId.get());
          localJSONObject.putOpt("status", Integer.valueOf(paramArrayOfByte.status.get()));
          localJSONObject.putOpt("msg", paramArrayOfByte.msg.get());
          localJSONObject.putOpt("exist", Integer.valueOf(paramArrayOfByte.existStatus.get()));
          paramBundle.putString("key_result_data", localJSONObject.toString());
          notifyObserver(paramIntent, 1082, true, paramBundle, MiniAppObserver.class);
          return;
          paramArrayOfByte = null;
        }
        catch (Throwable paramArrayOfByte)
        {
          for (;;)
          {
            QLog.i("BookShelfUpdateServlet", 1, "", paramArrayOfByte);
          }
        }
      }
    }
    notifyObserver(paramIntent, 1082, false, paramBundle, MiniAppObserver.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject1 = paramIntent.getStringExtra("key_appid");
    Object localObject2 = paramIntent.getStringExtra("key_category");
    String str = paramIntent.getStringExtra("key_contentId");
    int i = paramIntent.getIntExtra("key_index", -1);
    localObject2 = new BookShelfUpdateRequest((String)localObject1, (String)localObject2, str).encode(paramIntent, i, getTraceId());
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new byte[4];
    }
    paramPacket.setSSOCommand("LightAppSvc.mini_book_shelf.UpdateBookShelfReadTime");
    paramPacket.putSendData(bgau.a((byte[])localObject1));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.BookShelfUpdateServlet
 * JD-Core Version:    0.7.0.1
 */