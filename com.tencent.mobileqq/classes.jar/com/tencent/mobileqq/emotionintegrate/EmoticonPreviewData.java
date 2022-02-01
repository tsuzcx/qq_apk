package com.tencent.mobileqq.emotionintegrate;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public abstract class EmoticonPreviewData
{
  public static EmoticonPreviewData a(Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.containsKey("cur_data_source_type")))
    {
      QLog.d("EmoticonPreviewData", 1, "restoreSaveInstanceState execute");
      int i = paramBundle.getInt("cur_data_source_type");
      if (i == 0) {
        return new MsgEmoticonPreviewData(null).b(paramBundle);
      }
      if (i == 1) {
        return new FavEmoticonPreviewData(null).b(paramBundle);
      }
    }
    return null;
  }
  
  public abstract int a(List<EmoticonPreviewData> paramList);
  
  public abstract long a();
  
  public abstract Drawable a(Context paramContext);
  
  public abstract CustomEmotionData a();
  
  public abstract EmoticonInfo a();
  
  public void a(Bundle paramBundle, int paramInt)
  {
    paramBundle.putInt("cur_data_source_type", paramInt);
  }
  
  public abstract boolean a();
  
  public abstract boolean a(EmoticonPreviewData paramEmoticonPreviewData);
  
  public abstract boolean b();
  
  public abstract boolean c();
  
  public abstract boolean d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.EmoticonPreviewData
 * JD-Core Version:    0.7.0.1
 */