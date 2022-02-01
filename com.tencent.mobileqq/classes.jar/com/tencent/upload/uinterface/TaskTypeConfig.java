package com.tencent.upload.uinterface;

import com.tencent.upload.network.route.RouteFactory;
import com.tencent.upload.network.route.ServerRouteTable;

public final class TaskTypeConfig
{
  public static final TaskTypeConfig AirVideoUploadTaskType = new TaskTypeConfig(37, 1, RouteFactory.OTHER_ROUTE_TABLE);
  public static final TaskTypeConfig AudioStreamUploadTaskType = new TaskTypeConfig(39, 0, RouteFactory.OTHER_ROUTE_TABLE);
  public static final TaskTypeConfig AudioUploadTaskType = new TaskTypeConfig(2, 2, RouteFactory.OTHER_ROUTE_TABLE);
  public static final TaskTypeConfig BatchCommitUploadType = new TaskTypeConfig(0, 0, RouteFactory.PICTURE_ROUTE_TABLE);
  public static final TaskTypeConfig HeadUploadTaskType = new TaskTypeConfig(3, 0, RouteFactory.OTHER_ROUTE_TABLE);
  public static final TaskTypeConfig ImageUploadTaskType = new TaskTypeConfig(0, 0, RouteFactory.PICTURE_ROUTE_TABLE);
  public static final TaskTypeConfig LiveVideoUploadTaskType = new TaskTypeConfig(37, 1, RouteFactory.VIDEO_ROUTE_TABLE);
  public static final TaskTypeConfig LoverImageUploadTaskType = new TaskTypeConfig(6, 0, RouteFactory.OTHER_ROUTE_TABLE);
  public static final TaskTypeConfig MobileLogUploadTaskType = new TaskTypeConfig(36, 3, RouteFactory.LOG_ROUTE_TABLE);
  public static final TaskTypeConfig NewQunUploadTaskType = new TaskTypeConfig(22, 0, RouteFactory.PICTURE_ROUTE_TABLE);
  public static final TaskTypeConfig PhotoWallUploadTaskType = new TaskTypeConfig(17, 0, RouteFactory.OTHER_ROUTE_TABLE);
  public static final TaskTypeConfig QunUploadTaskType = new TaskTypeConfig(12, 0, RouteFactory.OTHER_ROUTE_TABLE);
  public static final TaskTypeConfig UppUploadTaskType = new TaskTypeConfig(4, 0, RouteFactory.OTHER_ROUTE_TABLE);
  public static final TaskTypeConfig UpsUploadTaskType = new TaskTypeConfig(13, 0, RouteFactory.OTHER_ROUTE_TABLE);
  public static final TaskTypeConfig VideoUploadTaskType = new TaskTypeConfig(1, 1, RouteFactory.VIDEO_ROUTE_TABLE);
  public static final TaskTypeConfig ZipUploadTaskType = new TaskTypeConfig(32, 2, RouteFactory.OTHER_ROUTE_TABLE);
  public final ServerRouteTable serverRouteTable;
  public final int uploadFileType;
  public final int uploadType;
  
  public TaskTypeConfig(int paramInt1, int paramInt2, ServerRouteTable paramServerRouteTable)
  {
    this.uploadType = paramInt1;
    this.uploadFileType = paramInt2;
    this.serverRouteTable = paramServerRouteTable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.uinterface.TaskTypeConfig
 * JD-Core Version:    0.7.0.1
 */