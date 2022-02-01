package com.tencent.mobileqq.kandian.biz.share;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.kandian.biz.atlas.ReadInJoyAtlasManager.AtlasCallback;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import tencent.im.oidb.FavoriteCKVData.KandianFavoriteBizData;

public class KandianFavoriteBroadcastReceiver
  extends BroadcastReceiver
{
  public static final String a;
  private ReadInJoyAtlasManager.AtlasCallback b;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Q.readinjoy.atlas..");
    localStringBuilder.append(KandianFavoriteBroadcastReceiver.class.getSimpleName());
    a = localStringBuilder.toString();
  }
  
  public KandianFavoriteBroadcastReceiver(ReadInJoyAtlasManager.AtlasCallback paramAtlasCallback)
  {
    this.b = paramAtlasCallback;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    paramIntent = paramIntent.getExtras();
    paramContext = paramIntent.getString("cid");
    int i = paramIntent.getInt("operation");
    boolean bool = paramIntent.getBoolean("isSuccess");
    paramIntent = (ArrayList)paramIntent.get("bizData");
    if ((paramIntent != null) && (paramIntent.size() > 0))
    {
      Object localObject = new FavoriteCKVData.KandianFavoriteBizData();
      try
      {
        ((FavoriteCKVData.KandianFavoriteBizData)localObject).mergeFrom((byte[])paramIntent.get(0));
        paramIntent = ((FavoriteCKVData.KandianFavoriteBizData)localObject).bytes_rowkey.get().toStringUtf8();
        if (QLog.isColorLevel())
        {
          localObject = a;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("BroadcastReceiver.onReceive  operation == ");
          localStringBuilder.append(i);
          localStringBuilder.append(" rowkey=");
          localStringBuilder.append(paramIntent);
          localStringBuilder.append(" cid=");
          localStringBuilder.append(paramContext);
          QLog.d((String)localObject, 2, localStringBuilder.toString());
        }
        if (this.b != null)
        {
          this.b.a(bool, paramIntent, i, paramContext);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramContext)
      {
        paramContext.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.KandianFavoriteBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */