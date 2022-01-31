package com.tencent.mobileqq.musicgene;

import aeky;
import aekz;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.music.IQQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONObject;

public class MusicPlayerActivity$MusicPlayerObserver
  implements BusinessObserver
{
  private final WeakReference a;
  
  public MusicPlayerActivity$MusicPlayerObserver(MusicPlayerActivity paramMusicPlayerActivity)
  {
    this.a = new WeakReference(paramMusicPlayerActivity);
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    MusicPlayerActivity localMusicPlayerActivity = (MusicPlayerActivity)this.a.get();
    String str2;
    if (((paramObject instanceof String)) && (localMusicPlayerActivity != null))
    {
      str2 = (String)paramObject;
      QLog.d("MusicPlayerActivity", 4, new Object[] { "musicPlayerActivity onUpdate ", String.valueOf(str2) });
    }
    String str1;
    Object localObject8;
    String str4;
    String str3;
    Object localObject9;
    Object localObject6;
    long l3;
    boolean bool2;
    long l1;
    Object localObject4;
    Object localObject3;
    boolean bool1;
    Object localObject5;
    Object localObject1;
    switch (paramInt)
    {
    default: 
      return;
    case 81: 
      str1 = "";
      localObject8 = "";
      str4 = "";
      str3 = "";
      localObject9 = "";
      localObject6 = "";
      paramBoolean = false;
      l3 = 0L;
      bool2 = false;
      l1 = l3;
      localObject4 = str3;
      localObject3 = str4;
      bool1 = paramBoolean;
      localObject5 = localObject6;
      localObject1 = localObject8;
      paramObject = str1;
    }
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject(str2).getJSONObject("data");
        l1 = l3;
        localObject4 = str3;
        localObject3 = str4;
        bool1 = paramBoolean;
        localObject5 = localObject6;
        localObject1 = localObject8;
        paramObject = str1;
        str1 = localJSONObject.optString("picurl");
        l1 = l3;
        localObject4 = str3;
        localObject3 = str4;
        bool1 = paramBoolean;
        localObject5 = localObject6;
        localObject1 = localObject8;
        paramObject = str1;
        str2 = localJSONObject.optString("lyric");
        l1 = l3;
        localObject4 = str3;
        localObject3 = str4;
        bool1 = paramBoolean;
        localObject5 = localObject6;
        localObject1 = str2;
        paramObject = str1;
        str5 = localJSONObject.optString("shareurl");
        l1 = l3;
        localObject4 = str3;
        localObject3 = str4;
        bool1 = paramBoolean;
        localObject5 = str5;
        localObject1 = str2;
        paramObject = str1;
        if (!localJSONObject.has("isfavorite")) {
          continue;
        }
        l1 = l3;
        localObject4 = str3;
        localObject3 = str4;
        bool1 = paramBoolean;
        localObject5 = str5;
        localObject1 = str2;
        paramObject = str1;
        paramInt = localJSONObject.getInt("isfavorite");
      }
      catch (Exception localException)
      {
        try
        {
          JSONObject localJSONObject;
          String str5;
          localObject1 = ((IQQPlayerService)localObject1).a();
          if (!bool2) {
            continue;
          }
          ReportController.b(localMusicPlayerActivity.app, "CliOper", "", "", "0X8006827", "0X8006827", 0, 0, "", "", "", "");
          if (localObject1 == null) {
            continue;
          }
          str1 = MusicPlayerActivity.a(localMusicPlayerActivity, (SongInfo)localObject1);
          localObject9 = paramObject;
          if (TextUtils.isEmpty(paramObject)) {
            continue;
          }
          localObject9 = paramObject.replace("&apos;", "'").replace("&quot;", "\"").replace("&nbsp;", " ").replace("&lt;", "<").replace("&gt;", ">").replace("&amp;", "&");
          MusicPlayerActivity.a().put(str1, Long.valueOf(l2));
          MusicPlayerActivity.d().put(str1, localObject9);
          if (localObject1 == null) {
            continue;
          }
          paramObject = new aekz(l2, (String)localObject4, (String)localObject3, (String)localObject8, (String)localObject6, (String)localObject5, paramBoolean);
          localObject9 = MusicPlayerActivity.a(localMusicPlayerActivity, (SongInfo)localObject1);
          MusicPlayerActivity.b().put(localObject9, paramObject);
          paramObject = new aeky((String)localObject4, (String)localObject3, (String)localObject5, (String)localObject6, (String)localObject8, "http://qzonestyle.gtimg.cn/ac/qzone/applogo/16/308/100497308_16.gif");
          localObject6 = Message.obtain(MusicPlayerActivity.a(localMusicPlayerActivity), 51);
          if (!bool2) {
            continue;
          }
          paramInt = 1;
          ((Message)localObject6).arg1 = paramInt;
          ((Message)localObject6).obj = paramObject;
          ((Message)localObject6).sendToTarget();
          Message.obtain(MusicPlayerActivity.a(localMusicPlayerActivity), 53).sendToTarget();
          MusicPlayerActivity.a(localMusicPlayerActivity, (String)localObject4, (String)localObject3, (String)localObject5, MusicPlayerActivity.a(localMusicPlayerActivity, MusicPlayerActivity.a(localMusicPlayerActivity), (SongInfo)localObject1, l2), paramBoolean, bool2);
          return;
          paramInt = 0;
          break label1074;
          paramBoolean = false;
          continue;
          localException = localException;
          bool2 = false;
          paramBoolean = bool1;
          Object localObject7 = localObject5;
          localObject8 = "";
          localObject5 = localObject3;
          localObject9 = paramObject;
          long l2 = l1;
          localObject3 = localObject4;
          localObject4 = localObject5;
          paramObject = localObject1;
          localObject5 = localObject9;
        }
        catch (RemoteException localRemoteException)
        {
          localObject2 = null;
          continue;
          paramInt = 0;
          continue;
        }
      }
      l2 = l3;
      localObject8 = str3;
      localObject6 = str4;
      l1 = l3;
      localObject4 = str3;
      localObject3 = str4;
      bool1 = paramBoolean;
      localObject5 = str5;
      localObject1 = str2;
      paramObject = str1;
      if (!localJSONObject.isNull("songinfo"))
      {
        l1 = l3;
        localObject4 = str3;
        localObject3 = str4;
        bool1 = paramBoolean;
        localObject5 = str5;
        localObject1 = str2;
        paramObject = str1;
        localObject9 = localJSONObject.getJSONObject("songinfo");
        l1 = l3;
        localObject4 = str3;
        localObject3 = str4;
        bool1 = paramBoolean;
        localObject5 = str5;
        localObject1 = str2;
        paramObject = str1;
        localObject6 = ((JSONObject)localObject9).optString("strSongName");
        l1 = l3;
        localObject4 = str3;
        localObject3 = localObject6;
        bool1 = paramBoolean;
        localObject5 = str5;
        localObject1 = str2;
        paramObject = str1;
        localObject8 = ((JSONObject)localObject9).optString("strSingerName");
        l1 = l3;
        localObject4 = localObject8;
        localObject3 = localObject6;
        bool1 = paramBoolean;
        localObject5 = str5;
        localObject1 = str2;
        paramObject = str1;
        l2 = ((JSONObject)localObject9).getInt("iSongId");
        l1 = l2;
        localObject4 = localObject8;
        localObject3 = localObject6;
        bool1 = paramBoolean;
        localObject5 = str5;
        localObject1 = str2;
        paramObject = str1;
        localObject9 = ((JSONObject)localObject9).optString("strUrl");
        bool2 = true;
      }
      localObject3 = localObject8;
      localObject4 = localObject6;
      paramObject = str2;
      localObject5 = str1;
      localObject8 = localObject9;
      localObject6 = str5;
      localObject1 = MusicPlayerActivity.a(localMusicPlayerActivity);
      if (localObject1 != null)
      {
        QLog.d("MusicPlayerActivity", 4, new Object[] { "MusicPlayerActivity add favourite success ", String.valueOf(str2) });
        for (;;)
        {
          try
          {
            if (new JSONObject(str2).getInt("code") != 0) {
              break;
            }
            paramObject = MusicPlayerActivity.a(localMusicPlayerActivity).getTag();
            if ((paramObject instanceof Integer))
            {
              paramInt = ((Integer)paramObject).intValue();
              Message.obtain(MusicPlayerActivity.a(localMusicPlayerActivity), 54, 2131438479, paramInt, MusicPlayerActivity.a(localMusicPlayerActivity)).sendToTarget();
              return;
            }
          }
          catch (Exception paramObject)
          {
            QLog.d("MusicPlayerActivity", 1, "add favourite parse json ", paramObject);
            return;
          }
          paramInt = -1;
        }
        QLog.d("MusicPlayerActivity", 4, new Object[] { "MusicPlayerActivity del favourite success ", String.valueOf(str2) });
        return;
      }
      Object localObject2 = null;
      continue;
      label1074:
      if (paramInt == 1) {
        paramBoolean = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.musicgene.MusicPlayerActivity.MusicPlayerObserver
 * JD-Core Version:    0.7.0.1
 */