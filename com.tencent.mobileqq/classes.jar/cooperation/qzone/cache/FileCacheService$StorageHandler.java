package cooperation.qzone.cache;

public abstract interface FileCacheService$StorageHandler
{
  public abstract void onCheckAndCleanStorage();
  
  public abstract void onLowStorage(FileCacheService paramFileCacheService, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.cache.FileCacheService.StorageHandler
 * JD-Core Version:    0.7.0.1
 */