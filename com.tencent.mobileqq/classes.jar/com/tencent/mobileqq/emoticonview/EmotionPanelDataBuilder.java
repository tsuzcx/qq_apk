package com.tencent.mobileqq.emoticonview;

import android.text.TextUtils;
import aqzt;
import arad;
import aray;
import arba;
import avsq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class EmotionPanelDataBuilder
{
  public static final String TAG = "EmotionPanelDataBuilder";
  private static EmotionPanelDataBuilder sInstance;
  
  public static EmotionPanelDataBuilder getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new EmotionPanelDataBuilder();
      }
      return sInstance;
    }
    finally {}
  }
  
  public void AsyncGetEmotionPanelData(QQAppInterface paramQQAppInterface, int paramInt1, EmoticonPackage paramEmoticonPackage, int paramInt2, int paramInt3, boolean paramBoolean, EmotionPanelDataBuilder.EmotionPanelDataCallback paramEmotionPanelDataCallback)
  {
    if (paramEmotionPanelDataCallback == null) {
      return;
    }
    ThreadManager.post(new EmotionPanelDataBuilder.1(this, paramQQAppInterface, paramInt1, paramEmoticonPackage, paramInt2, paramInt3, paramBoolean, paramEmotionPanelDataCallback), 5, null, true);
  }
  
  public List<EmotionPanelData> syncGetEmotionPanelData(QQAppInterface paramQQAppInterface, int paramInt1, EmoticonPackage paramEmoticonPackage, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmotionPanelDataBuilder", 2, "getEmotionPanelData panelType = " + paramInt1);
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = (avsq)paramQQAppInterface.getManager(14);
    switch (paramInt1)
    {
    }
    Emoticon localEmoticon;
    label603:
    for (;;)
    {
      return localArrayList;
      return SystemAndEmojiEmoticonInfo.getEmoticonList(paramQQAppInterface, paramInt3);
      localArrayList.add(new EmotionPanelData());
      return localArrayList;
      paramQQAppInterface = ((arba)paramQQAppInterface.getManager(149)).b();
      paramEmoticonPackage = new EmoticonInfo();
      paramEmoticonPackage.action = "favEdit";
      localArrayList.add(paramEmoticonPackage);
      if (paramInt2 != 1024)
      {
        paramEmoticonPackage = new EmoticonInfo();
        paramEmoticonPackage.action = "funny_pic";
        localArrayList.add(paramEmoticonPackage);
      }
      if (paramQQAppInterface != null)
      {
        if (paramQQAppInterface.size() > aray.a)
        {
          localArrayList.addAll(new ArrayList(paramQQAppInterface.subList(0, aray.a)));
          return localArrayList;
        }
        localArrayList.addAll(paramQQAppInterface);
        return localArrayList;
        paramQQAppInterface = ((arad)paramQQAppInterface.getManager(333)).b();
        paramEmoticonPackage = new CameraEmoticonInfo();
        paramEmoticonPackage.action = "cameraEdit";
        localArrayList.add(paramEmoticonPackage);
        paramEmoticonPackage = new CameraEmoticonInfo();
        paramEmoticonPackage.action = "cameraJump";
        localArrayList.add(paramEmoticonPackage);
        if (paramQQAppInterface != null)
        {
          if (paramQQAppInterface.size() > aqzt.a)
          {
            localArrayList.addAll(new ArrayList(paramQQAppInterface.subList(0, aqzt.a)));
            return localArrayList;
          }
          localArrayList.addAll(paramQQAppInterface);
          return localArrayList;
          paramQQAppInterface = new PicEmoticonInfo(paramQQAppInterface.getCurrentAccountUin());
          paramQQAppInterface.action = "push";
          paramEmoticonPackage = ((avsq)localObject1).b(0);
          localArrayList.add(paramQQAppInterface);
          localArrayList.addAll(paramEmoticonPackage);
          return localArrayList;
          paramQQAppInterface = ((avsq)localObject1).a(true, paramInt3, paramBoolean);
          if (paramQQAppInterface != null)
          {
            localArrayList.addAll(paramQQAppInterface);
            return localArrayList;
            if ((paramEmoticonPackage == null) || (TextUtils.isEmpty(paramEmoticonPackage.epId))) {
              return null;
            }
            localObject1 = ((avsq)localObject1).a(paramEmoticonPackage.epId, true);
            if (paramEmoticonPackage.jobType == 4) {}
            for (paramInt1 = 1;; paramInt1 = 0)
            {
              if (localObject1 == null) {
                break label603;
              }
              paramInt3 = ((List)localObject1).size();
              paramInt2 = 0;
              while (paramInt2 < paramInt3)
              {
                localEmoticon = (Emoticon)((List)localObject1).get(paramInt2);
                if (paramInt1 == 0) {
                  break label605;
                }
                localObject2 = new SmallEmoticonInfo(paramQQAppInterface.getCurrentAccountUin());
                ((SmallEmoticonInfo)localObject2).type = 10;
                ((SmallEmoticonInfo)localObject2).imageType = paramEmoticonPackage.type;
                ((SmallEmoticonInfo)localObject2).emoticon = localEmoticon;
                localArrayList.add(localObject2);
                paramInt2 += 1;
              }
              break;
            }
          }
        }
      }
    }
    label605:
    Object localObject2 = new PicEmoticonInfo(paramQQAppInterface.getCurrentAccountUin());
    ((PicEmoticonInfo)localObject2).type = 6;
    ((PicEmoticonInfo)localObject2).imageType = paramEmoticonPackage.type;
    ((PicEmoticonInfo)localObject2).emoticon = localEmoticon;
    if (paramEmoticonPackage.isAPNG == 2) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((PicEmoticonInfo)localObject2).isAPNG = paramBoolean;
      localArrayList.add(localObject2);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPanelDataBuilder
 * JD-Core Version:    0.7.0.1
 */