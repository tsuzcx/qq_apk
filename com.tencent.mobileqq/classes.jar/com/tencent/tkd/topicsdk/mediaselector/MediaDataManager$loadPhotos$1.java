package com.tencent.tkd.topicsdk.mediaselector;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Images.Media;
import com.tencent.tkd.topicsdk.bean.Media;
import com.tencent.tkd.topicsdk.bean.MediaType;
import com.tencent.tkd.topicsdk.common.FileUtils;
import com.tencent.tkd.topicsdk.framework.ThreadManagerKt;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class MediaDataManager$loadPhotos$1
  extends Lambda
  implements Function0<Unit>
{
  MediaDataManager$loadPhotos$1(Context paramContext, Function2 paramFunction2)
  {
    super(0);
  }
  
  public final void invoke()
  {
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    Object localObject1 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    Cursor localCursor = this.$context.getContentResolver().query((Uri)localObject1, new String[] { "_id", "_data", "_size", "_display_name" }, "mime_type =? or mime_type=? or mime_type=? or mime_type=?", new String[] { "image/jpeg", "image/png", "image/gif", "image/bmp" }, "date_modified desc");
    if (localCursor != null)
    {
      while (localCursor.moveToNext())
      {
        localObject1 = localCursor.getString(localCursor.getColumnIndex("_data"));
        if (FileUtils.a.a((String)localObject1))
        {
          Media localMedia = new Media(MediaType.PHOTO);
          localObject1 = localCursor.getString(localCursor.getColumnIndex("_data"));
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "cursor.getString(cursor.…Store.Images.Media.DATA))");
          localMedia.setFilePath((String)localObject1);
          localMedia.setSize(localCursor.getLong(localCursor.getColumnIndex("_size")));
          localArrayList.add(localMedia);
          localObject1 = new File(localMedia.getFilePath());
          if ((((File)localObject1).exists()) && (((File)localObject1).getParentFile() != null))
          {
            localObject1 = ((File)localObject1).getParentFile();
            Intrinsics.checkExpressionValueIsNotNull(localObject1, "mediaFile.parentFile");
            String str = ((File)localObject1).getAbsolutePath();
            Object localObject2 = (ArrayList)localHashMap.get(str);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              localObject1 = new ArrayList();
              localObject2 = (Map)localHashMap;
              Intrinsics.checkExpressionValueIsNotNull(str, "dirPath");
              ((Map)localObject2).put(str, localObject1);
            }
            ((ArrayList)localObject1).add(localMedia);
          }
        }
      }
      localCursor.close();
    }
    MediaDataManager.a(MediaDataManager.a, localHashMap, localArrayList);
    ThreadManagerKt.a((Function0)new MediaDataManager.loadPhotos.1.1(this, localArrayList, localHashMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.MediaDataManager.loadPhotos.1
 * JD-Core Version:    0.7.0.1
 */