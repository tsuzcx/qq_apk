import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gameroom.seat.background.SurvivalMemberItemView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class nko
  extends BaseAdapter
{
  protected Context a;
  protected LayoutInflater a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  protected ndl a;
  protected nkj a;
  private nkk jdField_a_of_type_Nkk;
  
  public nko(Context paramContext, nkj paramnkj)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Nkj = paramnkj;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Ndl = ((ndl)nfc.a().a().a(2));
    this.jdField_a_of_type_Nkk = new nkk();
    this.jdField_a_of_type_Nkj.a(this.jdField_a_of_type_Nkk);
    this.jdField_a_of_type_Nkj.a(this);
  }
  
  private View a(int paramInt, View paramView)
  {
    if (paramInt < 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("SurvivalSeatBgGridAdapter", 4, "getMemberView invalide position " + paramInt);
      }
      return paramView;
    }
    nkl localnkl = this.jdField_a_of_type_Nkk.a(paramInt);
    View localView;
    Object localObject;
    if (!(paramView instanceof SurvivalMemberItemView))
    {
      paramView = (SurvivalMemberItemView)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558772, null);
      paramView.setAlpha(0.5F);
      paramView.a();
      localView = paramView;
      localObject = paramView;
    }
    for (;;)
    {
      ((SurvivalMemberItemView)localObject).a(this.jdField_a_of_type_Ndl, localnkl, this.jdField_a_of_type_Nkj);
      return localView;
      localObject = (SurvivalMemberItemView)paramView;
      localView = paramView;
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Nkk == null) || (paramInt < 0) || (this.jdField_a_of_type_AndroidViewViewGroup == null)) {
      if (QLog.isDevelopLevel()) {
        QLog.d("SurvivalSeatBgGridAdapter", 4, "invalid params updateItemView at " + paramInt);
      }
    }
    SurvivalMemberItemView localSurvivalMemberItemView;
    nkl localnkl;
    do
    {
      return;
      localSurvivalMemberItemView = (SurvivalMemberItemView)this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(paramInt);
      localnkl = this.jdField_a_of_type_Nkk.a(paramInt);
      if (localSurvivalMemberItemView != null) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("SurvivalSeatBgGridAdapter", 4, "updateItemView itemView is null or member is null");
    return;
    localSurvivalMemberItemView.a(this.jdField_a_of_type_Ndl, localnkl, this.jdField_a_of_type_Nkj);
  }
  
  public int getCount()
  {
    return nin.y;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_Nkk == null) {
      return new nkl(0L);
    }
    if (this.jdField_a_of_type_Nkk.a(paramInt) == null) {
      return new Object();
    }
    return new nkl(0L);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    View localView = a(paramInt, paramView);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 1;
  }
  
  public boolean isEmpty()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nko
 * JD-Core Version:    0.7.0.1
 */