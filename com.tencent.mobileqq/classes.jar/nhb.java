import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.SwipListView;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.List;

public class nhb
  extends amoe
  implements View.OnClickListener, blih
{
  private final int jdField_a_of_type_Int = 8;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private List<RoomInfo> jdField_a_of_type_JavaUtilList = new ArrayList(0);
  private mxp jdField_a_of_type_Mxp = new nhc(this);
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  
  public nhb(Activity paramActivity, QQAppInterface paramQQAppInterface, SwipListView paramSwipListView, View paramView, String paramString)
  {
    super(paramActivity, paramQQAppInterface, paramSwipListView, 1, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.b = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131296565);
    this.c = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131296564);
    e();
    a(this);
  }
  
  private void a(LinearLayout paramLinearLayout, List<Player> paramList)
  {
    if (paramLinearLayout == null) {
      return;
    }
    paramLinearLayout.removeAllViews();
    if ((paramList == null) || (paramList.size() == 0))
    {
      paramLinearLayout.setVisibility(8);
      return;
    }
    int i = 0;
    if ((i < paramList.size()) && (i < 8))
    {
      Object localObject1 = (Player)paramList.get(i);
      Object localObject2 = bhmq.a();
      localObject1 = aoot.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, ((Player)localObject1).uin, 3, (Drawable)localObject2, (Drawable)localObject2, 4);
      localObject2 = new ThemeImageView(this.jdField_a_of_type_AndroidAppActivity);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.b, this.b);
      if (i == 0) {}
      for (int j = 0;; j = this.c)
      {
        localLayoutParams.leftMargin = j;
        ((ThemeImageView)localObject2).setLayoutParams(localLayoutParams);
        ((ThemeImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_CENTER);
        ((ThemeImageView)localObject2).setBackgroundDrawable((Drawable)localObject1);
        paramLinearLayout.addView((View)localObject2);
        i += 1;
        break;
      }
    }
    paramLinearLayout.setVisibility(0);
  }
  
  private void a(List<RoomInfo> paramList1, List<RoomInfo> paramList2)
  {
    int i = 0;
    while (i < paramList2.size())
    {
      RoomInfo localRoomInfo = (RoomInfo)paramList2.get(i);
      if (!paramList1.contains(localRoomInfo)) {
        paramList1.add(localRoomInfo);
      }
      i += 1;
    }
  }
  
  private void e()
  {
    this.d = 0;
    this.e = 0;
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Boolean) {}
    mxc localmxc;
    do
    {
      return;
      localmxc = (mxc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(373);
    } while (localmxc == null);
    this.d = this.e;
    this.jdField_a_of_type_Boolean = true;
    localmxc.a(this.jdField_a_of_type_JavaLangString, this.d, 2);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVGameRoomListFragment", 2, "adapter onResume");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Mxp);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVGameRoomListFragment", 2, "adapter onPause");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Mxp);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Mxp);
    super.c();
  }
  
  public void d()
  {
    e();
    mxc localmxc = (mxc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(373);
    if (localmxc != null) {
      localmxc.a(this.jdField_a_of_type_JavaLangString, 0, 2);
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    Object localObject2;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131558736, null);
      paramView = new nhe();
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131363205));
      paramView.b = ((TextView)localView.findViewById(2131363206));
      paramView.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131363204));
      localView.setTag(paramView);
      localView.setOnClickListener(this);
      localView.setOnTouchListener(new nhd(this));
      localObject1 = new GradientDrawable();
      ((GradientDrawable)localObject1).setCornerRadius(bhtq.a(5.0F));
      ((GradientDrawable)localObject1).setColor(-7510273);
      ((GradientDrawable)localObject1).setShape(0);
      localObject2 = new GradientDrawable();
      ((GradientDrawable)localObject2).setCornerRadius(bhtq.a(5.0F));
      ((GradientDrawable)localObject2).setColor(-7510273);
      ((GradientDrawable)localObject2).setShape(0);
      localView.setBackgroundDrawable(URLDrawable.getDrawable("https://static-res.qq.com/static-res/avgames/avgame_room_list_item_bg.png", (Drawable)localObject1, (Drawable)localObject2));
      localObject1 = getItem(paramInt);
      if (!(localObject1 instanceof RoomInfo)) {
        break label415;
      }
    }
    label415:
    for (Object localObject1 = (RoomInfo)localObject1;; localObject1 = null)
    {
      localObject2 = new StringBuilder(nhs.a(((RoomInfo)localObject1).id));
      if (((StringBuilder)localObject2).length() == 9)
      {
        ((StringBuilder)localObject2).insert(6, "-");
        ((StringBuilder)localObject2).insert(3, "-");
      }
      localObject2 = this.jdField_a_of_type_AndroidAppActivity.getString(2131690340) + " " + ((StringBuilder)localObject2).toString();
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      localObject2 = String.format(this.jdField_a_of_type_AndroidAppActivity.getString(2131690339), new Object[] { Integer.valueOf(((RoomInfo)localObject1).players.size()) });
      paramView.b.setText((CharSequence)localObject2);
      paramView.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo = ((RoomInfo)localObject1);
      a(paramView.jdField_a_of_type_AndroidWidgetLinearLayout, ((RoomInfo)localObject1).players);
      localView.setLayoutParams(new AbsListView.LayoutParams(-1, bhtq.a(80.0F)));
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject1 = (nhe)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject1;
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    switch (paramView.getId())
    {
    }
    do
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    } while (!(localObject instanceof nhe));
    localObject = ((nhe)localObject).jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo;
    mxc localmxc = (mxc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(373);
    if (localmxc != null) {
      localmxc.a(this.jdField_a_of_type_AndroidAppActivity, 5, String.valueOf(((RoomInfo)localObject).id), this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_JavaLangString != null) {}
    for (localObject = this.jdField_a_of_type_JavaLangString;; localObject = "")
    {
      bdll.b(null, "dc00898", "", "", "0X800B01C", "0X800B01C", 0, 0, "", "", (String)localObject, "");
      break;
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.f = (paramInt1 + paramInt2 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.f == getCount() - 1)) {
      f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nhb
 * JD-Core Version:    0.7.0.1
 */