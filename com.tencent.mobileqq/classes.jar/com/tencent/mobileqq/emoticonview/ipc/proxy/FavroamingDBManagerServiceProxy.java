package com.tencent.mobileqq.emoticonview.ipc.proxy;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import java.util.ArrayList;
import java.util.List;

public class FavroamingDBManagerServiceProxy
  extends AbsEmoRuntimeServiceProxy<IFavroamingDBManagerService>
{
  public static final String TAG = "FavroamingDBManagerServiceProxy";
  
  public FavroamingDBManagerServiceProxy(BaseQQAppInterface paramBaseQQAppInterface)
  {
    super(paramBaseQQAppInterface, IFavroamingDBManagerService.class);
  }
  
  public void delOverflow(List<CustomEmotionData> paramList)
  {
    if (this.manager != null) {
      ((IFavroamingDBManagerService)this.manager).delOverflow(paramList);
    }
  }
  
  public List<CustomEmotionData> getEmoticonDataList()
  {
    if (this.manager != null) {
      return ((IFavroamingDBManagerService)this.manager).getEmoticonDataList();
    }
    return new ArrayList();
  }
  
  public List<EmoticonInfo> syncGetCustomEmotionInfoShowedInPanel()
  {
    if (this.manager != null) {
      return ((IFavroamingDBManagerService)this.manager).syncGetCustomEmotionInfoShowedInPanel();
    }
    return new ArrayList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ipc.proxy.FavroamingDBManagerServiceProxy
 * JD-Core Version:    0.7.0.1
 */