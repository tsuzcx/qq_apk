import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class tdo
  implements AbsListView.OnScrollListener
{
  boolean jdField_a_of_type_Boolean = false;
  
  tdo(tdn paramtdn) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt3 > 0) && (paramAbsListView.getFirstVisiblePosition() + paramInt2 >= paramInt3)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((this.jdField_a_of_type_Boolean) && (paramInt == 0) && (!tdn.a(this.jdField_a_of_type_Tdn)) && (!tdn.b(this.jdField_a_of_type_Tdn)))
    {
      tlo.c(tdn.a(this.jdField_a_of_type_Tdn), "onScrollStateChanged scrollState:" + paramInt);
      tdn.a(this.jdField_a_of_type_Tdn, this.jdField_a_of_type_Tdn.a().a(tdn.b(this.jdField_a_of_type_Tdn)));
      if (tdn.c(this.jdField_a_of_type_Tdn) != null)
      {
        this.jdField_a_of_type_Tdn.a().a(tdn.a(this.jdField_a_of_type_Tdn), true);
        tdn.a(this.jdField_a_of_type_Tdn, true);
      }
    }
    else
    {
      return;
    }
    tlo.c(tdn.a(this.jdField_a_of_type_Tdn), "mCommentAttachInfo is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tdo
 * JD-Core Version:    0.7.0.1
 */