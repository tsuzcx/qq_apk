import com.tencent.biz.qqstory.model.AddressDataProvider;
import com.tencent.biz.qqstory.model.AddressDataProvider.AddressInfo;
import com.tencent.biz.qqstory.model.DataProviderManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.music.EditVideoMusicDialog;
import com.tencent.biz.qqstory.takevideo.music.MusicGridAdapter;
import com.tencent.qphone.base.util.QLog;

class ojs
  implements Runnable
{
  ojs(ojr paramojr, AddressDataProvider.AddressInfo paramAddressInfo) {}
  
  public void run()
  {
    SLog.b("Q.qqstory.publish.edit.EditVideoMusicDialog", "address update, refresh ui.");
    if (((AddressDataProvider)((DataProviderManager)SuperManager.a(20)).a(1)).a(this.jdField_a_of_type_ComTencentBizQqstoryModelAddressDataProvider$AddressInfo))
    {
      QLog.d("zivonchen", 2, "isInternationalUser --------------------2");
      this.jdField_a_of_type_Ojr.a.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ojs
 * JD-Core Version:    0.7.0.1
 */