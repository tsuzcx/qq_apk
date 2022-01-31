import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.POIPosterItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.takevideo.EditVideoDoodle;
import com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager.DoodleEmojiUpdatePoiPostersEvent;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.LocationFacePackage;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.LocationFacePackage.Item;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public class oei
  extends QQUIEventReceiver
{
  public oei(@NonNull EditVideoDoodle paramEditVideoDoodle)
  {
    super(paramEditVideoDoodle);
  }
  
  public void a(@NonNull EditVideoDoodle paramEditVideoDoodle, @NonNull DoodleEmojiManager.DoodleEmojiUpdatePoiPostersEvent paramDoodleEmojiUpdatePoiPostersEvent)
  {
    oej localoej = paramEditVideoDoodle.jdField_a_of_type_Oej;
    int i = paramDoodleEmojiUpdatePoiPostersEvent.jdField_a_of_type_Int;
    paramDoodleEmojiUpdatePoiPostersEvent = paramDoodleEmojiUpdatePoiPostersEvent.jdField_a_of_type_JavaUtilList;
    paramEditVideoDoodle = paramEditVideoDoodle.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage;
    if (localoej != null)
    {
      if (i != 0)
      {
        SLog.b(this.TAG, "DoodleEmojiPoiPostersReceiver, location failed.");
        paramEditVideoDoodle.jdField_a_of_type_Boolean = false;
        localoej.a(paramEditVideoDoodle);
        VideoEditReport.a("0X80076CD");
        VideoEditReport.b("0X80075E2");
        return;
      }
      SLog.b(this.TAG, "DoodleEmojiPoiPostersReceiver, location success.");
      paramEditVideoDoodle.jdField_a_of_type_JavaUtilList.clear();
      paramDoodleEmojiUpdatePoiPostersEvent = paramDoodleEmojiUpdatePoiPostersEvent.iterator();
      while (paramDoodleEmojiUpdatePoiPostersEvent.hasNext())
      {
        POIPosterItem localPOIPosterItem = (POIPosterItem)paramDoodleEmojiUpdatePoiPostersEvent.next();
        if ((TextUtils.isEmpty(localPOIPosterItem.d)) || (TextUtils.isEmpty(localPOIPosterItem.a)) || (TextUtils.isEmpty(localPOIPosterItem.b))) {
          SLog.d(this.TAG, "find illegal content : url=%s, name=%s, des=%s", new Object[] { localPOIPosterItem.d, localPOIPosterItem.a, localPOIPosterItem.b });
        }
        LocationFacePackage.Item localItem = new LocationFacePackage.Item();
        localItem.d = localPOIPosterItem.d;
        localItem.b = localPOIPosterItem.a;
        localItem.c = localPOIPosterItem.b;
        localItem.a = localPOIPosterItem.c;
        localItem.e = localPOIPosterItem.e;
        paramEditVideoDoodle.jdField_a_of_type_JavaUtilList.add(localItem);
      }
      paramEditVideoDoodle.jdField_a_of_type_Boolean = false;
      localoej.a(paramEditVideoDoodle);
      return;
    }
    SLog.b(this.TAG, "DoodleEmojiPoiPostersReceiver adapter is null");
  }
  
  public Class acceptEventClass()
  {
    return DoodleEmojiManager.DoodleEmojiUpdatePoiPostersEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oei
 * JD-Core Version:    0.7.0.1
 */