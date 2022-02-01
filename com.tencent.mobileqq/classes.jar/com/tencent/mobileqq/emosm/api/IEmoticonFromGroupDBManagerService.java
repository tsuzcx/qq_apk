package com.tencent.mobileqq.emosm.api;

import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IEmoticonFromGroupDBManagerService<T>
  extends IRuntimeService
{
  public static final int MAX_EMO_FROM_GROUP_SIZE = 600;
  public static final int MAX_SHOW_DATA_SIZE = 300;
  public static final int MAX_SIZE_WRITE_TO_DB = 10;
  public static final int NO_SYNC = 0;
  public static final int OP_ADD = 1;
  public static final int OP_DELETE = 2;
  public static final int SYNC_ING = 1;
  public static final int SYNC_SUC = 2;
  public static final int WRITE_EMO_FROM_GROUP_SIZE = 400;
  
  public abstract void decreaseCountOfSpare();
  
  public abstract void deleteCacheAndDB(MessageRecord paramMessageRecord);
  
  public abstract void deleteDataFromCache(T paramT);
  
  public abstract void deleteDataFromCache(List<T> paramList);
  
  public abstract void enableWrite2DBAfterTenSec();
  
  public abstract int getAddedEmoCacheDataSize();
  
  public abstract int getCountOfSpare();
  
  public abstract int getDBCacheSize();
  
  public abstract List<T> getEmoDataForShow();
  
  public abstract List<T> getEmoDataShowing();
  
  public abstract List<URLDrawable> getUploadDrawableList();
  
  public abstract void loadDB();
  
  public abstract void setCountOfSpare(int paramInt);
  
  public abstract void update2DB(T paramT, int paramInt);
  
  public abstract void update2DB(List<T> paramList, int paramInt);
  
  public abstract void updateDBCache(MessageRecord paramMessageRecord);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.IEmoticonFromGroupDBManagerService
 * JD-Core Version:    0.7.0.1
 */