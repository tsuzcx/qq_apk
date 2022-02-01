package com.tencent.mobileqq.flashchat;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
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
  public static ArrayList<FlashChatItem> a(byte[] paramArrayOfByte)
  {
    try
    {
      FlashChatSso.TSsoRsp localTSsoRsp = new FlashChatSso.TSsoRsp();
      localTSsoRsp.mergeFrom(paramArrayOfByte);
      if (localTSsoRsp.st_cmd0x1_rsp.has())
      {
        paramArrayOfByte = new ArrayList();
        int i = 0;
        while (i < localTSsoRsp.st_cmd0x1_rsp.item.size())
        {
          FlashChatSso.TItem localTItem = (FlashChatSso.TItem)localTSsoRsp.st_cmd0x1_rsp.item.get(i);
          FlashChatItem localFlashChatItem = new FlashChatItem();
          localFlashChatItem.id = localTItem.i32_id.get();
          localFlashChatItem.feedType = localTItem.uint32_feetype.get();
          localFlashChatItem.name = localTItem.string_name.get();
          localFlashChatItem.appName = localTItem.string_app_name.get();
          localFlashChatItem.iconUrl = localTItem.string_icon_url.get();
          localFlashChatItem.mainView = localTItem.string_main_view.get();
          localFlashChatItem.ver = localTItem.string_ver.get();
          localFlashChatItem.color = localTItem.string_bg_color.get();
          paramArrayOfByte.add(localFlashChatItem);
          i += 1;
        }
        return paramArrayOfByte;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool;
    if (paramFromServiceMsg == null) {
      bool = false;
    } else {
      bool = paramFromServiceMsg.isSuccess();
    }
    int i = paramIntent.getIntExtra("req_type", 0);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onReceive cmd:");
      ((StringBuilder)localObject1).append(i);
      QLog.d("FlashChat", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new Bundle();
    if (bool) {
      try
      {
        Object localObject2 = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = new byte[((ByteBuffer)localObject2).getInt() - 4];
        ((ByteBuffer)localObject2).get(paramFromServiceMsg);
        if (i == 1)
        {
          localObject2 = a(paramFromServiceMsg);
          if (localObject2 != null)
          {
            ((FlashChatManager)getAppRuntime().getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).a((ArrayList)localObject2, true, paramFromServiceMsg);
            notifyObserver(paramIntent, 967, bool, (Bundle)localObject1, FlashChatObserver.class);
            return;
          }
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
      }
    }
    notifyObserver(paramIntent, 967, false, (Bundle)localObject1, FlashChatObserver.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i = paramIntent.getIntExtra("req_type", -1);
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("onSend cmd:");
      paramIntent.append(i);
      QLog.d("FlashChat", 2, paramIntent.toString());
    }
    if (i != 1) {
      return;
    }
    paramIntent = new FlashChatSso.TSsoReq();
    paramIntent.i32_cmd.set(1);
    paramIntent.i32_implat.set(109);
    paramIntent.str_qq_ver.set("8.8.17");
    paramIntent = paramIntent.toByteArray();
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramIntent.length + 4);
    localByteBuffer.putInt(paramIntent.length + 4).put(paramIntent);
    paramIntent = localByteBuffer.array();
    paramPacket.setSSOCommand("Flashchat.OpReq");
    paramPacket.putSendData(paramIntent);
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("FlashChatServlet onSend ssoCmd:");
      paramIntent.append("Flashchat.OpReq");
      QLog.d("FlashChat", 2, paramIntent.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatServlet
 * JD-Core Version:    0.7.0.1
 */