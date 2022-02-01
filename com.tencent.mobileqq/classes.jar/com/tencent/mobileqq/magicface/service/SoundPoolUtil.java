package com.tencent.mobileqq.magicface.service;

import android.media.SoundPool;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Timer;

public class SoundPoolUtil
{
  protected SoundPool a;
  protected HashMap<String, Integer> a;
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidMediaSoundPool != null)
    {
      QQAudioUtils.a(BaseApplicationImpl.getContext(), false);
      this.jdField_a_of_type_AndroidMediaSoundPool.release();
    }
  }
  
  public void a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilHashMap;
    if (localObject != null)
    {
      localObject = (Integer)((HashMap)localObject).get(paramString);
      if (localObject != null)
      {
        QQAudioUtils.a(BaseApplicationImpl.getContext(), false);
        this.jdField_a_of_type_AndroidMediaSoundPool.stop(((Integer)localObject).intValue());
        this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
      }
    }
  }
  
  public boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = this.jdField_a_of_type_JavaUtilHashMap;
      if ((localObject != null) && (((HashMap)localObject).containsKey(paramString))) {
        return false;
      }
      localObject = new File(paramString);
      if (!((File)localObject).exists()) {
        return false;
      }
      if (this.jdField_a_of_type_AndroidMediaSoundPool == null) {
        this.jdField_a_of_type_AndroidMediaSoundPool = new SoundPool(1, 3, 0);
      }
      if (this.jdField_a_of_type_JavaUtilHashMap == null) {
        this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      }
      if (Build.VERSION.SDK_INT >= 8) {
        this.jdField_a_of_type_AndroidMediaSoundPool.setOnLoadCompleteListener(null);
      }
      int i = this.jdField_a_of_type_AndroidMediaSoundPool.load(((File)localObject).getAbsolutePath(), 1);
      if (i == 0)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("load failure filepath=");
          ((StringBuilder)localObject).append(paramString);
          QLog.d("SoundPoolUtil", 2, ((StringBuilder)localObject).toString());
        }
        return false;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(i));
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    QQAudioUtils.a(BaseApplicationImpl.getContext(), true);
    if (this.jdField_a_of_type_AndroidMediaSoundPool == null) {
      this.jdField_a_of_type_AndroidMediaSoundPool = new SoundPool(1, paramInt2, 0);
    }
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
    {
      if (!a(paramString)) {
        return false;
      }
      if (Build.VERSION.SDK_INT >= 8)
      {
        this.jdField_a_of_type_AndroidMediaSoundPool.setOnLoadCompleteListener(new SoundPoolUtil.1(this, paramInt1, paramString));
        return true;
      }
      paramInt1 = ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).intValue();
      ThreadManager.getTimer().schedule(new SoundPoolUtil.2(this, paramInt1, paramString), 200L);
      return true;
    }
    paramInt1 = ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).intValue();
    if (this.jdField_a_of_type_AndroidMediaSoundPool.play(paramInt1, 1.0F, 1.0F, 0, 0, 1.0F) == 0)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("play failure filepath=");
        localStringBuilder.append(paramString);
        QLog.d("SoundPoolUtil", 2, localStringBuilder.toString());
      }
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.service.SoundPoolUtil
 * JD-Core Version:    0.7.0.1
 */