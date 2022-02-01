package com.tencent.mobileqq.mini.servlet;

import NS_MINI_BOOK_SHELF.MiniBookShelf.Information;
import NS_MINI_BOOK_SHELF.MiniBookShelf.StQueryBookShelfRsp;
import android.content.Intent;
import android.os.Bundle;
import bgau;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.Packet;
import org.json.JSONArray;
import org.json.JSONObject;

public class BookShelfQueryServlet
  extends MiniAppAbstractServlet
{
  public static final String KEY_APPID = "key_appid";
  public static final String KEY_CONTENT_ID_LIST = "key_contentIds";
  public static final String KEY_RESULT_DATA = "key_result_data";
  public static final String TAG = "BookShelfQueryServlet";
  
  public BookShelfQueryServlet()
  {
    this.observerId = 1081;
  }
  
  public void onProcessData(Intent paramIntent, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = BookShelfQueryRequest.onResponse(paramArrayOfByte);
    if (paramArrayOfByte != null) {
      paramArrayOfByte = paramArrayOfByte.bookInfo.get();
    }
    JSONArray localJSONArray;
    for (;;)
    {
      if (paramArrayOfByte == null) {
        break label220;
      }
      localJSONArray = new JSONArray();
      int i = 0;
      label33:
      if (i < paramArrayOfByte.size()) {
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.putOpt("contentId", ((MiniBookShelf.Information)paramArrayOfByte.get(i)).contentId.get());
          localJSONObject.putOpt("status", Integer.valueOf(((MiniBookShelf.Information)paramArrayOfByte.get(i)).status.get()));
          localJSONObject.putOpt("msg", ((MiniBookShelf.Information)paramArrayOfByte.get(i)).msg.get());
          localJSONObject.putOpt("exist", Integer.valueOf(((MiniBookShelf.Information)paramArrayOfByte.get(i)).existStatus.get()));
          localJSONArray.put(localJSONObject);
          i += 1;
          break label33;
          paramArrayOfByte = null;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            QLog.i("BookShelfQueryServlet", 1, "", localThrowable);
          }
        }
      }
    }
    paramBundle.putString("key_result_data", localJSONArray.toString());
    notifyObserver(paramIntent, 1081, true, paramBundle, MiniAppObserver.class);
    return;
    label220:
    notifyObserver(paramIntent, 1081, false, paramBundle, MiniAppObserver.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject1 = paramIntent.getStringExtra("key_appid");
    Object localObject2 = paramIntent.getStringArrayListExtra("key_contentIds");
    int i = paramIntent.getIntExtra("key_index", -1);
    localObject2 = new BookShelfQueryRequest((String)localObject1, (ArrayList)localObject2).encode(paramIntent, i, getTraceId());
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new byte[4];
    }
    paramPacket.setSSOCommand("LightAppSvc.mini_book_shelf.QueryBookShelf");
    paramPacket.putSendData(bgau.a((byte[])localObject1));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.BookShelfQueryServlet
 * JD-Core Version:    0.7.0.1
 */