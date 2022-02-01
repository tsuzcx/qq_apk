package cooperation.comic.ui;

import android.util.SparseArray;
import com.tencent.mobileqq.redtouch.RedAppInfo;
import com.tencent.mobileqq.redtouch.RedTouchUI;
import cooperation.comic.VipComicJumpActivity;
import cooperation.comic.jsp.QQComicDownloadCountObserver;
import cooperation.comic.utils.SimpleBiMap;
import java.util.List;

class QQComicTabBarView$3
  implements QQComicDownloadCountObserver
{
  QQComicTabBarView$3(QQComicTabBarView paramQQComicTabBarView) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    paramInt1 = this.a.a();
    if ((this.a.jdField_a_of_type_JavaUtilList == null) || (paramInt1 < 0) || (paramInt1 >= this.a.jdField_a_of_type_JavaUtilList.size())) {}
    RedTouchUI localRedTouchUI;
    RedAppInfo localRedAppInfo;
    do
    {
      return;
      paramInt2 = VipComicJumpActivity.a("fav", this.a.jdField_a_of_type_JavaUtilList);
      if ((paramBoolean) && (paramInt1 != paramInt2))
      {
        this.a.a(paramInt2);
        return;
      }
      localRedTouchUI = (RedTouchUI)this.a.jdField_a_of_type_CooperationComicUtilsSimpleBiMap.get("1113.100801");
      localRedAppInfo = (RedAppInfo)this.a.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2);
    } while ((localRedTouchUI == null) || (!localRedTouchUI.c()) || (localRedAppInfo == null) || (localRedTouchUI.a != localRedAppInfo));
    this.a.a(paramInt2, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.comic.ui.QQComicTabBarView.3
 * JD-Core Version:    0.7.0.1
 */