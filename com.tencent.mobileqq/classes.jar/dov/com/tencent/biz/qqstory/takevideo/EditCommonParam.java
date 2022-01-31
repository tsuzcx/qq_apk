package dov.com.tencent.biz.qqstory.takevideo;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.network.request.PublishStoryVideoRequest;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.qq.im.capture.music.QimMusicPlayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools;
import org.json.JSONException;
import org.json.JSONObject;

public class EditCommonParam
  extends EditVideoPart
{
  public EditCommonParam(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    super.a(paramInt, paramGenerateContext);
    QIMFilterCategoryItem localQIMFilterCategoryItem = VideoFilterTools.a().a(VideoFilterTools.a().c());
    Object localObject3 = VideoFilterTools.a().b(VideoFilterTools.a().c());
    Object localObject2 = ((QimMusicPlayer)QIMManager.a().c(8)).b();
    Object localObject1 = new JSONObject();
    if ((localQIMFilterCategoryItem == null) || (!TextUtils.isEmpty(localQIMFilterCategoryItem.b))) {}
    try
    {
      ((JSONObject)localObject1).put(PublishStoryVideoRequest.y, localQIMFilterCategoryItem.b);
      for (;;)
      {
        label87:
        if ((localObject3 != null) && (!TextUtils.isEmpty(((QIMFilterCategoryItem)localObject3).b)) && (!((QIMFilterCategoryItem)localObject3).c())) {}
        try
        {
          ((JSONObject)localObject1).put(PublishStoryVideoRequest.w, ((QIMFilterCategoryItem)localObject3).b);
          label124:
          if ((localObject2 != null) && (!TextUtils.isEmpty(((MusicItemInfo)localObject2).a))) {}
          try
          {
            ((JSONObject)localObject1).put(PublishStoryVideoRequest.x, ((MusicItemInfo)localObject2).a);
            label153:
            localObject2 = (EditDoodleExport)a(EditDoodleExport.class);
            if ((localObject2 == null) || (((EditDoodleExport)localObject2).a() == null))
            {
              if (QLog.isColorLevel()) {
                QLog.d("EditCommonParam", 2, "doodleExport == null or getDoodleLayout == null");
              }
              return;
              if (TextUtils.isEmpty(localQIMFilterCategoryItem.d)) {
                continue;
              }
              try
              {
                ((JSONObject)localObject1).put(PublishStoryVideoRequest.y, localQIMFilterCategoryItem.d);
              }
              catch (JSONException localJSONException5) {}
              continue;
            }
            localObject3 = ((EditDoodleExport)localObject2).a().a();
            if ((!"0".equals(QIMPtvTemplateAdapter.b)) || ((localObject3 != null) && (!((FaceLayer)localObject3).a()))) {}
            try
            {
              ((JSONObject)localObject1).put(PublishStoryVideoRequest.v, "趣味");
              label272:
              localObject2 = ((EditDoodleExport)localObject2).a().a(paramInt);
              if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
              try
              {
                ((JSONObject)localObject1).put(PublishStoryVideoRequest.u, localObject2);
                label303:
                localObject1 = ((JSONObject)localObject1).toString();
                SLog.a("EditCommonParam", "effectsName = %s", localObject1);
                paramGenerateContext.a.putExtra("VideoEffectExtra", localObject1);
                return;
              }
              catch (JSONException localJSONException1)
              {
                break label303;
              }
            }
            catch (JSONException localJSONException3)
            {
              break label272;
            }
          }
          catch (JSONException localJSONException2)
          {
            break label153;
          }
        }
        catch (JSONException localJSONException4)
        {
          break label124;
        }
      }
    }
    catch (JSONException localJSONException6)
    {
      break label87;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditCommonParam
 * JD-Core Version:    0.7.0.1
 */