package com.tencent.mobileqq.emosm;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.CameraEmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.FavoriteEmoticonInfo;
import com.tencent.mobileqq.emoticonview.ICustomEmotionInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class BaseEmosmStrategy
  implements IEmosmStrategy
{
  protected BaseQQAppInterface a;
  FavEmosmViewPage b;
  AtomicBoolean c = new AtomicBoolean();
  List<FavoriteEmoticonInfo> d = new ArrayList();
  public boolean e = false;
  public boolean f = false;
  MultiEmotionSaveManager g = null;
  
  public BaseEmosmStrategy(BaseQQAppInterface paramBaseQQAppInterface, FavEmosmViewPage paramFavEmosmViewPage)
  {
    this.a = paramBaseQQAppInterface;
    this.b = paramFavEmosmViewPage;
    this.g = new MultiEmotionSaveManager(paramBaseQQAppInterface);
  }
  
  public View a(int paramInt, View paramView, FavEmosmViewPage.Holder paramHolder, EmoticonInfo paramEmoticonInfo)
  {
    return paramView;
  }
  
  public String a(EmoticonInfo paramEmoticonInfo)
  {
    return null;
  }
  
  public List<EmoticonInfo> a(List<EmoticonInfo> paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      EmoticonInfo localEmoticonInfo = (EmoticonInfo)paramList.next();
      Object localObject;
      if ((localEmoticonInfo instanceof CameraEmoticonInfo))
      {
        localObject = (CameraEmoticonInfo)localEmoticonInfo;
        if ((!TextUtils.isEmpty(((CameraEmoticonInfo)localObject).roamingType)) && (!((CameraEmoticonInfo)localObject).roamingType.equals("needUpload"))) {
          localArrayList.add(localEmoticonInfo);
        }
      }
      else if ((localEmoticonInfo instanceof FavoriteEmoticonInfo))
      {
        localObject = (FavoriteEmoticonInfo)localEmoticonInfo;
        if ((!TextUtils.isEmpty(((FavoriteEmoticonInfo)localObject).roamingType)) && (!((FavoriteEmoticonInfo)localObject).roamingType.equals("needUpload"))) {
          localArrayList.add(localEmoticonInfo);
        }
      }
      else
      {
        localArrayList.add(localEmoticonInfo);
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.c.set(false);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 10015) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseEmosmStrategy", 2, "onActivityResult, PeakConstants.REQUEST_CODE_FOR_PHOTO_PREVIEW");
    }
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
      if (paramIntent != null)
      {
        ThreadManager.excute(new BaseEmosmStrategy.2(this, paramIntent), 64, null, false);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("BaseEmosmStrategy", 2, "onActivityResult, selected is empty");
      }
    }
    else
    {
      QLog.e("BaseEmosmStrategy", 1, "onActivityResult, PeakConstants.REQUEST_CODE_FOR_PHOTO_PREVIEW, data is null");
    }
  }
  
  public void a(Context paramContext, Intent paramIntent)
  {
    if (this.b == null) {
      return;
    }
    paramContext = paramIntent.getAction();
    if ("com.tencent.mobileqq.action.refresh.emotiom".equals(paramContext))
    {
      this.b.k();
      return;
    }
    if ("com.tencent.mobileqq.action.upload.emotiom".equals(paramContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseEmosmStrategy", 2, "onReceive ACTION_UPLOAD_EMOTION");
      }
      paramContext = paramIntent.getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
      if (paramContext != null)
      {
        ThreadManager.excute(new BaseEmosmStrategy.1(this, paramContext), 64, null, false);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("BaseEmosmStrategy", 2, "onReceive selected is empty");
      }
    }
  }
  
  public void a(CustomEmotionRoamingDBManagerBase.CustomEmotionDataInPanelCallback paramCustomEmotionDataInPanelCallback)
  {
    n().asyncGetFavEmotionInfoShowedInPanel(paramCustomEmotionDataInPanelCallback);
  }
  
  public void a(GridView paramGridView, int paramInt, ICustomEmotionInfo paramICustomEmotionInfo) {}
  
  public boolean a(Activity paramActivity)
  {
    return false;
  }
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    return false;
  }
  
  public MultiEmotionSaveManager b()
  {
    return this.g;
  }
  
  public boolean c()
  {
    return false;
  }
  
  public boolean d()
  {
    return true;
  }
  
  public void e()
  {
    Object localObject = this.b;
    if (localObject == null) {
      return;
    }
    List localList = a(((FavEmosmViewPage)localObject).l);
    localObject = localList;
    if (localList == null) {
      localObject = new ArrayList();
    }
    if ((((List)localObject).size() > 0) && (((EmoticonInfo)((List)localObject).get(0)).operateType == 1)) {
      ((List)localObject).remove(0);
    }
    this.b.d((List)localObject);
  }
  
  public void f()
  {
    Object localObject1 = this.b;
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = ((FavEmosmViewPage)localObject1).l;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ArrayList();
    }
    if (c()) {
      if (((List)localObject1).size() > 0)
      {
        if (((EmoticonInfo)((List)localObject1).get(0)).operateType != 1)
        {
          localObject2 = new EmoticonInfo();
          ((EmoticonInfo)localObject2).operateType = 1;
          ((List)localObject1).add(0, localObject2);
        }
      }
      else
      {
        localObject2 = new EmoticonInfo();
        ((EmoticonInfo)localObject2).operateType = 1;
        ((List)localObject1).add(0, localObject2);
      }
    }
    this.b.d((List)localObject1);
  }
  
  public int g()
  {
    return 2131888877;
  }
  
  public void h()
  {
    this.g.onDestroy();
    this.b = null;
  }
  
  public void i() {}
  
  public void j() {}
  
  public void k() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.BaseEmosmStrategy
 * JD-Core Version:    0.7.0.1
 */