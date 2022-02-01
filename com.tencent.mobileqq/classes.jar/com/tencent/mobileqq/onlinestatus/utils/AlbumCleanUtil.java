package com.tencent.mobileqq.onlinestatus.utils;

import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import java.util.HashMap;

public class AlbumCleanUtil
  extends QAlbumUtil
{
  public static void a()
  {
    sLastAlbumPhotoCountMap.clear();
    sLastAlbumPath = null;
    sLastAlbumRecordTime = 0L;
    sLastAlbumId = null;
    sLastAlbumName = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.utils.AlbumCleanUtil
 * JD-Core Version:    0.7.0.1
 */