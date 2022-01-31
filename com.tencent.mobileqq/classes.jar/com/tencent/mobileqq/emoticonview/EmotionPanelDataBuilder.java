package com.tencent.mobileqq.emoticonview;

import acft;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class EmotionPanelDataBuilder
{
  private static EmotionPanelDataBuilder a;
  
  public static EmotionPanelDataBuilder a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new EmotionPanelDataBuilder();
      }
      return a;
    }
    finally {}
  }
  
  public List a(QQAppInterface paramQQAppInterface, int paramInt1, EmoticonPackage paramEmoticonPackage, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmotionPanelDataBuilder", 2, "getEmotionPanelData panelType = " + paramInt1);
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = (EmoticonManager)paramQQAppInterface.getManager(13);
    switch (paramInt1)
    {
    }
    Emoticon localEmoticon;
    label466:
    for (;;)
    {
      return localArrayList;
      return SystemAndEmojiEmoticonInfo.a(paramQQAppInterface);
      localArrayList.add(new EmotionPanelData());
      return localArrayList;
      paramQQAppInterface = ((FavroamingDBManager)paramQQAppInterface.getManager(148)).b();
      paramEmoticonPackage = new EmoticonInfo();
      paramEmoticonPackage.jdField_a_of_type_JavaLangString = "favEdit";
      localArrayList.add(paramEmoticonPackage);
      if (paramInt2 != 1024)
      {
        paramEmoticonPackage = new EmoticonInfo();
        paramEmoticonPackage.jdField_a_of_type_JavaLangString = "funny_pic";
        localArrayList.add(paramEmoticonPackage);
      }
      if (paramQQAppInterface != null)
      {
        if (paramQQAppInterface.size() > FavEmoConstant.jdField_a_of_type_Int)
        {
          localArrayList.addAll(paramQQAppInterface.subList(0, FavEmoConstant.jdField_a_of_type_Int));
          return localArrayList;
        }
        localArrayList.addAll(paramQQAppInterface);
        return localArrayList;
        paramQQAppInterface = new PicEmoticonInfo(paramQQAppInterface.getCurrentAccountUin());
        paramQQAppInterface.jdField_a_of_type_JavaLangString = "push";
        localArrayList.addAll(((EmoticonManager)localObject1).b(0));
        localArrayList.add(paramQQAppInterface);
        return localArrayList;
        localArrayList.addAll(((EmoticonManager)localObject1).a(true, paramInt3, paramBoolean));
        return localArrayList;
        if ((paramEmoticonPackage == null) || (TextUtils.isEmpty(paramEmoticonPackage.epId))) {
          return null;
        }
        localObject1 = ((EmoticonManager)localObject1).a(paramEmoticonPackage.epId, true);
        if (paramEmoticonPackage.jobType == 4) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (localObject1 == null) {
            break label466;
          }
          paramInt3 = ((List)localObject1).size();
          paramInt2 = 0;
          while (paramInt2 < paramInt3)
          {
            localEmoticon = (Emoticon)((List)localObject1).get(paramInt2);
            if (paramInt1 == 0) {
              break label468;
            }
            localObject2 = new SmallEmoticonInfo(paramQQAppInterface.getCurrentAccountUin());
            ((SmallEmoticonInfo)localObject2).c = 10;
            ((SmallEmoticonInfo)localObject2).jdField_a_of_type_Int = paramEmoticonPackage.type;
            ((SmallEmoticonInfo)localObject2).jdField_a_of_type_ComTencentMobileqqDataEmoticon = localEmoticon;
            localArrayList.add(localObject2);
            paramInt2 += 1;
          }
          break;
        }
      }
    }
    label468:
    Object localObject2 = new PicEmoticonInfo(paramQQAppInterface.getCurrentAccountUin());
    ((PicEmoticonInfo)localObject2).c = 6;
    ((PicEmoticonInfo)localObject2).f = paramEmoticonPackage.type;
    ((PicEmoticonInfo)localObject2).jdField_a_of_type_ComTencentMobileqqDataEmoticon = localEmoticon;
    if (paramEmoticonPackage.isAPNG == 2) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((PicEmoticonInfo)localObject2).b = paramBoolean;
      localArrayList.add(localObject2);
      break;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, EmoticonPackage paramEmoticonPackage, int paramInt2, int paramInt3, boolean paramBoolean, EmotionPanelDataBuilder.EmotionPanelDataCallback paramEmotionPanelDataCallback)
  {
    if (paramEmotionPanelDataCallback == null) {
      return;
    }
    ThreadManager.post(new acft(this, paramQQAppInterface, paramInt1, paramEmoticonPackage, paramInt2, paramInt3, paramBoolean, paramEmotionPanelDataCallback), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPanelDataBuilder
 * JD-Core Version:    0.7.0.1
 */