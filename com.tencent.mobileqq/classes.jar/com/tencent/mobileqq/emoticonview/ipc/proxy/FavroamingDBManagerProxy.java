package com.tencent.mobileqq.emoticonview.ipc.proxy;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import java.util.ArrayList;
import java.util.List;

public class FavroamingDBManagerProxy
  extends AbsManagerProxy<FavroamingDBManager>
{
  public static final String TAG = "FavroamingDBManagerProxy";
  
  public FavroamingDBManagerProxy(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface, QQManagerFactory.FAVROAMING_DB_MANAGER);
  }
  
  public void delOverflow(List<CustomEmotionData> paramList)
  {
    if (this.manager != null) {
      ((FavroamingDBManager)this.manager).b(paramList);
    }
  }
  
  public List<CustomEmotionData> getEmoticonDataList()
  {
    if (this.manager != null) {
      return ((FavroamingDBManager)this.manager).a();
    }
    return new ArrayList();
  }
  
  public List<EmoticonInfo> syncGetCustomEmotionInfoShowedInPanel()
  {
    if (this.manager != null) {
      return ((FavroamingDBManager)this.manager).b();
    }
    return new ArrayList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ipc.proxy.FavroamingDBManagerProxy
 * JD-Core Version:    0.7.0.1
 */