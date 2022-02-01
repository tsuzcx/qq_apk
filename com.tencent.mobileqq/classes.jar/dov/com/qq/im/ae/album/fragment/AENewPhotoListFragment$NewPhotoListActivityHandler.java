package dov.com.qq.im.ae.album.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.album.logic.AEPhotoListLogic;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

class AENewPhotoListFragment$NewPhotoListActivityHandler
  extends Handler
{
  private final WeakReference<AENewPhotoListFragment> a;
  
  public AENewPhotoListFragment$NewPhotoListActivityHandler(AENewPhotoListFragment paramAENewPhotoListFragment)
  {
    this.a = new WeakReference(paramAENewPhotoListFragment);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((this.a == null) || (this.a.get() == null)) {}
    Object localObject;
    do
    {
      return;
      localObject = (AENewPhotoListFragment)this.a.get();
      switch (paramMessage.what)
      {
      default: 
        return;
      case 0: 
        localObject = ((AENewPhotoListFragment)localObject).jdField_a_of_type_DovComQqImAeAlbumFragmentAEAbstractPhotoListFragment$PhotoGridAdapter;
      }
    } while (localObject == null);
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(((AEAbstractPhotoListFragment.PhotoGridAdapter)localObject).a);
    paramMessage = paramMessage.getData();
    int i = paramMessage.getInt("ALBUMLIST_POSITION");
    long l = paramMessage.getLong("ALBUMLIST_ITEM_DURATION");
    paramMessage = (LocalMediaInfo)localArrayList.get(i);
    paramMessage.mDuration = l;
    localArrayList.set(i, paramMessage);
    ((AEAbstractPhotoListFragment.PhotoGridAdapter)localObject).a(localArrayList, true);
    ((AEAbstractPhotoListFragment.PhotoGridAdapter)localObject).notifyDataSetChanged();
    return;
    ((AENewPhotoListFragment)this.a.get()).jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogic.a(paramMessage);
    return;
    ((AENewPhotoListFragment)localObject).h();
    QLog.e("PhotoListActivity", 2, new Object[] { "onEncodeError = ", Integer.valueOf(((Integer)paramMessage.obj).intValue()) });
    QQToast.a(((AENewPhotoListFragment)localObject).getActivity(), ((AENewPhotoListFragment)localObject).getResources().getString(2131694873), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.album.fragment.AENewPhotoListFragment.NewPhotoListActivityHandler
 * JD-Core Version:    0.7.0.1
 */