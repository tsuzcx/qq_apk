import com.tencent.biz.qqstory.takevideo.EditVideoMusic;
import com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import com.tencent.biz.qqstory.takevideo.EditVideoTagExport;
import com.tencent.biz.qqstory.takevideo.music.EditVideoMusicDialog;
import com.tencent.biz.qqstory.takevideo.tag.TagItem;
import com.tencent.biz.qqstory.takevideo.tag.TagItem.TagInfoBase;

public class odo
  implements Runnable
{
  public odo(EditVideoMusic paramEditVideoMusic) {}
  
  public void run()
  {
    if ((!this.a.d) && (this.a.e))
    {
      this.a.d = true;
      localObject = this.a.a(EditVideoTagExport.class);
      if (localObject == null) {
        break label145;
      }
    }
    label145:
    for (Object localObject = ((EditVideoTagExport)localObject).a(this.a.a.a());; localObject = null)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((TagItem)localObject).a.a == 1) {
          bool1 = true;
        }
      }
      new EditVideoMusicDialog(this.a.a(), this.a, this.a.c, (int)this.a.a.a(this.a.a.a()), this.a.a.a, true, bool1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     odo
 * JD-Core Version:    0.7.0.1
 */