package com.tencent.upload.uinterface;

import com.tencent.upload.network.route.RouteFactory.ServerCategory;

public final class TaskTypeConfig
{
  public static final TaskTypeConfig AirVideoUploadTaskType = new TaskTypeConfig(37, 1, RouteFactory.ServerCategory.OTHER);
  public static final TaskTypeConfig AudioStreamUploadTaskType = new TaskTypeConfig(39, 0, RouteFactory.ServerCategory.OTHER);
  public static final TaskTypeConfig AudioUploadTaskType = new TaskTypeConfig(2, 2, RouteFactory.ServerCategory.OTHER);
  public static final TaskTypeConfig BatchCommitUploadType = new TaskTypeConfig(0, 0, RouteFactory.ServerCategory.PICTURE);
  public static final TaskTypeConfig HeadUploadTaskType = new TaskTypeConfig(3, 0, RouteFactory.ServerCategory.OTHER);
  public static final TaskTypeConfig ImageUploadTaskType = new TaskTypeConfig(0, 0, RouteFactory.ServerCategory.PICTURE);
  public static final TaskTypeConfig LiveVideoUploadTaskType = new TaskTypeConfig(37, 1, RouteFactory.ServerCategory.VIDEO);
  public static final TaskTypeConfig LoverImageUploadTaskType = new TaskTypeConfig(6, 0, RouteFactory.ServerCategory.OTHER);
  public static final TaskTypeConfig MobileLogUploadTaskType = new TaskTypeConfig(36, RouteFactory.ServerCategory.LOG.code, RouteFactory.ServerCategory.LOG);
  public static final TaskTypeConfig NewQunUploadTaskType = new TaskTypeConfig(22, 0, RouteFactory.ServerCategory.OTHER);
  public static final TaskTypeConfig PhotoWallUploadTaskType = new TaskTypeConfig(17, 0, RouteFactory.ServerCategory.OTHER);
  public static final TaskTypeConfig QunUploadTaskType = new TaskTypeConfig(12, 0, RouteFactory.ServerCategory.OTHER);
  public static final TaskTypeConfig UppUploadTaskType = new TaskTypeConfig(4, 0, RouteFactory.ServerCategory.OTHER);
  public static final TaskTypeConfig UpsUploadTaskType = new TaskTypeConfig(13, 0, RouteFactory.ServerCategory.OTHER);
  public static final TaskTypeConfig VideoUploadTaskType = new TaskTypeConfig(1, 1, RouteFactory.ServerCategory.VIDEO);
  public final RouteFactory.ServerCategory serverCategory;
  public final int uploadFileType;
  public final int uploadType;
  
  public TaskTypeConfig(int paramInt1, int paramInt2, RouteFactory.ServerCategory paramServerCategory)
  {
    this.uploadType = paramInt1;
    this.uploadFileType = paramInt2;
    this.serverCategory = paramServerCategory;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.uinterface.TaskTypeConfig
 * JD-Core Version:    0.7.0.1
 */