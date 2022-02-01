package dov.com.qq.im.ae.gif.giftext.fragment;

import android.app.Activity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.UiThreadUtil;
import dov.com.qq.im.ae.entry.AECameraEntry;
import dov.com.qq.im.ae.gif.giftext.AEGIFTextMvp;
import dov.com.qq.im.ae.gif.video.VideoGIFCreator.Callback;
import dov.com.tencent.biz.qqstory.takevideo.ShortVideoForwardManager;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class AEGIFSinglePreviewFragment$4
  implements VideoGIFCreator.Callback
{
  AEGIFSinglePreviewFragment$4(AEGIFSinglePreviewFragment paramAEGIFSinglePreviewFragment, boolean paramBoolean) {}
  
  public void a()
  {
    QLog.d("AEGIFSinglePreviewFragment", 4, "onGifCreateFail");
    AEGIFSinglePreviewFragment.a(this.jdField_a_of_type_DovComQqImAeGifGiftextFragmentAEGIFSinglePreviewFragment);
    UiThreadUtil.a(new AEGIFSinglePreviewFragment.4.2(this));
  }
  
  public void a(String paramString)
  {
    QLog.d("AEGIFSinglePreviewFragment", 4, "onGifCreateSuccess, come from AECAMERA_MODE_ALL");
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    String str1;
    String str2;
    if (AEGIFSinglePreviewFragment.a(this.jdField_a_of_type_DovComQqImAeGifGiftextFragmentAEGIFSinglePreviewFragment) != null)
    {
      str1 = AEGIFSinglePreviewFragment.a(this.jdField_a_of_type_DovComQqImAeGifGiftextFragmentAEGIFSinglePreviewFragment).a();
      localArrayList1.add(paramString);
      localArrayList2.add(str1);
      StringBuilder localStringBuilder = new StringBuilder().append("gif^");
      if (AEGIFSinglePreviewFragment.a(this.jdField_a_of_type_DovComQqImAeGifGiftextFragmentAEGIFSinglePreviewFragment) != null) {
        break label196;
      }
      str2 = "";
      label97:
      localArrayList3.add(str2);
      if (!this.jdField_a_of_type_Boolean) {
        break label207;
      }
      AEGIFSinglePreviewFragment.a(this.jdField_a_of_type_DovComQqImAeGifGiftextFragmentAEGIFSinglePreviewFragment, localArrayList1, localArrayList2, localArrayList3);
      this.jdField_a_of_type_DovComQqImAeGifGiftextFragmentAEGIFSinglePreviewFragment.getActivity().setResult(201);
      this.jdField_a_of_type_DovComQqImAeGifGiftextFragmentAEGIFSinglePreviewFragment.getActivity().finish();
      paramString = this.jdField_a_of_type_DovComQqImAeGifGiftextFragmentAEGIFSinglePreviewFragment.getActivity().getApplicationContext();
      ThreadManager.getUIHandler().post(new AEGIFSinglePreviewFragment.4.1(this, paramString));
    }
    for (;;)
    {
      AEGIFSinglePreviewFragment.a(this.jdField_a_of_type_DovComQqImAeGifGiftextFragmentAEGIFSinglePreviewFragment);
      return;
      str1 = "";
      break;
      label196:
      str2 = AEGIFSinglePreviewFragment.a(this.jdField_a_of_type_DovComQqImAeGifGiftextFragmentAEGIFSinglePreviewFragment);
      break label97;
      label207:
      AEGIFSinglePreviewFragment.a(this.jdField_a_of_type_DovComQqImAeGifGiftextFragmentAEGIFSinglePreviewFragment, localArrayList1, localArrayList2, localArrayList3);
      if ((AEGIFSinglePreviewFragment.a(this.jdField_a_of_type_DovComQqImAeGifGiftextFragmentAEGIFSinglePreviewFragment)) && (AEGIFSinglePreviewFragment.a(this.jdField_a_of_type_DovComQqImAeGifGiftextFragmentAEGIFSinglePreviewFragment) != null)) {
        AEGIFSinglePreviewFragment.a(this.jdField_a_of_type_DovComQqImAeGifGiftextFragmentAEGIFSinglePreviewFragment, paramString, AEGIFSinglePreviewFragment.a(this.jdField_a_of_type_DovComQqImAeGifGiftextFragmentAEGIFSinglePreviewFragment), str1, AEGIFSinglePreviewFragment.a(this.jdField_a_of_type_DovComQqImAeGifGiftextFragmentAEGIFSinglePreviewFragment));
      } else {
        ShortVideoForwardManager.a(AEGIFSinglePreviewFragment.a(this.jdField_a_of_type_DovComQqImAeGifGiftextFragmentAEGIFSinglePreviewFragment), paramString, AECameraEntry.b(this.jdField_a_of_type_DovComQqImAeGifGiftextFragmentAEGIFSinglePreviewFragment.getActivity()), true, str1, AEGIFSinglePreviewFragment.a(this.jdField_a_of_type_DovComQqImAeGifGiftextFragmentAEGIFSinglePreviewFragment));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.fragment.AEGIFSinglePreviewFragment.4
 * JD-Core Version:    0.7.0.1
 */