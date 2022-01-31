package com.tencent.mobileqq.flashchat;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class FlashChatServlet
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool;
    Bundle localBundle;
    if (paramFromServiceMsg == null)
    {
      bool = false;
      i = paramIntent.getIntExtra("req_type", 0);
      if (QLog.isColorLevel()) {
        QLog.d("FlashChat", 2, "onReceive cmd:" + i);
      }
      localBundle = new Bundle();
      if (!bool) {}
    }
    do
    {
      try
      {
        paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        localObject = new byte[paramFromServiceMsg.getInt() - 4];
        paramFromServiceMsg.get((byte[])localObject);
        switch (i)
        {
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        for (;;)
        {
          Object localObject;
          paramFromServiceMsg.printStackTrace();
        }
      }
      notifyObserver(paramIntent, 967, false, localBundle, FlashChatObserver.class);
      return;
      bool = paramFromServiceMsg.isSuccess();
      break;
      paramFromServiceMsg = new FlashChatSso.TSsoRsp();
      paramFromServiceMsg.mergeFrom((byte[])localObject);
    } while (!paramFromServiceMsg.st_cmd0x1_rsp.has());
    localObject = new ArrayList();
    int i = 0;
    while (i < paramFromServiceMsg.st_cmd0x1_rsp.item.size())
    {
      FlashChatSso.TItem localTItem = (FlashChatSso.TItem)paramFromServiceMsg.st_cmd0x1_rsp.item.get(i);
      FlashChatItem localFlashChatItem = new FlashChatItem();
      localFlashChatItem.jdField_a_of_type_Int = localTItem.i32_id.get();
      localFlashChatItem.jdField_b_of_type_Int = localTItem.uint32_feetype.get();
      localFlashChatItem.jdField_b_of_type_JavaLangString = localTItem.string_name.get();
      localFlashChatItem.jdField_a_of_type_JavaLangString = localTItem.string_app_name.get();
      localFlashChatItem.c = localTItem.string_icon_url.get();
      localFlashChatItem.d = localTItem.string_main_view.get();
      localFlashChatItem.e = localTItem.string_ver.get();
      localFlashChatItem.f = localTItem.string_bg_color.get();
      ((ArrayList)localObject).add(localFlashChatItem);
      i += 1;
    }
    ((FlashChatManager)getAppRuntime().getManager(216)).a((ArrayList)localObject);
    notifyObserver(paramIntent, 967, bool, localBundle, FlashChatObserver.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i = paramIntent.getIntExtra("req_type", -1);
    if (QLog.isColorLevel()) {
      QLog.d("FlashChat", 2, "onSend cmd:" + i);
    }
    switch (i)
    {
    }
    do
    {
      return;
      paramIntent = new FlashChatSso.TSsoReq();
      paramIntent.i32_cmd.set(1);
      paramIntent.i32_implat.set(109);
      paramIntent.str_qq_ver.set("7.6.8");
      paramIntent = paramIntent.toByteArray();
      ByteBuffer localByteBuffer = ByteBuffer.allocate(paramIntent.length + 4);
      localByteBuffer.putInt(paramIntent.length + 4).put(paramIntent);
      paramIntent = localByteBuffer.array();
      paramPacket.setSSOCommand("Flashchat.OpReq");
      paramPacket.putSendData(paramIntent);
    } while (!QLog.isColorLevel());
    QLog.d("FlashChat", 2, "FlashChatServlet onSend ssoCmd:" + "Flashchat.OpReq");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatServlet
 * JD-Core Version:    0.7.0.1
 */