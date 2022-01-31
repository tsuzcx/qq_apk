import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.LikeRankingListActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.LikeRankingInfo;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.utils.ImageUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class swi
  extends BaseAdapter
{
  RelativeSizeSpan jdField_a_of_type_AndroidTextStyleRelativeSizeSpan = new RelativeSizeSpan(0.62F);
  String jdField_a_of_type_JavaLangString;
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  public boolean a;
  int[] jdField_a_of_type_ArrayOfInt = { 2130842590, 2130842591, 2130842592 };
  String jdField_b_of_type_JavaLangString;
  int[] jdField_b_of_type_ArrayOfInt = { 2130842587, 2130842588, 2130842589 };
  
  public swi(LikeRankingListActivity paramLikeRankingListActivity)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = paramLikeRankingListActivity.getString(2131438635);
    this.jdField_a_of_type_JavaLangString = paramLikeRankingListActivity.getString(2131438636);
  }
  
  public LikeRankingInfo a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (LikeRankingInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    int i = paramList.size() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        LikeRankingInfo localLikeRankingInfo = (LikeRankingInfo)paramList.get(i);
        if (localLikeRankingInfo.uin == this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo.uin) {
          this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo = localLikeRankingInfo;
        }
      }
      else
      {
        if ((this.jdField_a_of_type_JavaUtilList.size() == 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo.rankingNum > 3) && (this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo.likeCountOfToday > 0)) {
          this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo);
        }
        this.jdField_a_of_type_JavaUtilList.addAll(paramList);
        this.jdField_a_of_type_Boolean = false;
        notifyDataSetChanged();
        return;
      }
      i -= 1;
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size() + 1;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == getCount() - 1) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 8;
    int i = 0;
    int k = getItemViewType(paramInt);
    paramViewGroup = paramView;
    if (paramView == null) {}
    switch (k)
    {
    default: 
      paramViewGroup = paramView;
      switch (k)
      {
      }
      break;
    }
    LikeRankingInfo localLikeRankingInfo;
    do
    {
      return paramViewGroup;
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity).inflate(2130970357, null);
      paramView = new swk(this);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131370221));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131370222));
      paramView.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131370224));
      paramView.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131370223));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131363369));
      paramView.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131370227));
      paramView.d = ((TextView)paramViewGroup.findViewById(2131370226));
      paramView.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131363612);
      paramViewGroup.setTag(paramView);
      break;
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity).inflate(2130969104, null);
      paramView = new swj(this);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131364961));
      paramView.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramViewGroup.findViewById(2131363031));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131365150));
      paramViewGroup.setTag(paramView);
      break;
      localLikeRankingInfo = a(paramInt);
    } while (localLikeRankingInfo == null);
    swk localswk = (swk)paramViewGroup.getTag();
    localswk.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(paramInt));
    String str;
    if ((paramInt == 0) && (localLikeRankingInfo.uin == this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo.uin) && ((localLikeRankingInfo.rankingNum > 3) || (localLikeRankingInfo.rankingNum < 1)))
    {
      localswk.jdField_a_of_type_AndroidViewView.setVisibility(0);
      str = String.valueOf(localLikeRankingInfo.uin);
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.c(str);
      if (paramView == null) {
        break label633;
      }
      localswk.jdField_b_of_type_AndroidWidgetTextView.setText(paramView.getFriendNick());
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(1, str);
      paramView = (View)localObject;
      if (localObject == null)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(str, 1, true);
        }
        paramView = ImageUtil.a();
      }
      localswk.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramView);
      label462:
      switch (localLikeRankingInfo.rankingNum)
      {
      default: 
        if (localLikeRankingInfo.rankingNum < 1) {
          localswk.jdField_a_of_type_AndroidWidgetTextView.setText("-");
        }
        break;
      }
    }
    for (;;)
    {
      localswk.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      localswk.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      for (;;)
      {
        paramView = new SpannableString(String.format(Locale.CHINA, this.jdField_a_of_type_JavaLangString, new Object[] { Integer.valueOf(localLikeRankingInfo.likeCountOfToday) }));
        paramView.setSpan(this.jdField_a_of_type_AndroidTextStyleRelativeSizeSpan, 0, 1, 33);
        localswk.d.setText(paramView);
        localswk.jdField_c_of_type_AndroidWidgetTextView.setText(String.format(Locale.CHINA, this.jdField_b_of_type_JavaLangString, new Object[] { Integer.valueOf(localLikeRankingInfo.totalLikeCount) }));
        return paramViewGroup;
        localswk.jdField_a_of_type_AndroidViewView.setVisibility(8);
        break;
        label633:
        localswk.jdField_b_of_type_AndroidWidgetTextView.setText(str);
        localswk.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(ImageUtil.a());
        break label462;
        localswk.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(localLikeRankingInfo.rankingNum));
        localswk.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        localswk.jdField_b_of_type_AndroidWidgetImageView.setImageResource(this.jdField_b_of_type_ArrayOfInt[(localLikeRankingInfo.rankingNum - 1)]);
        localswk.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      localswk.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(localLikeRankingInfo.rankingNum));
    }
    paramView = (swj)paramViewGroup.getTag();
    Object localObject = paramView.jdField_a_of_type_AndroidWidgetTextView;
    if (this.jdField_a_of_type_Boolean)
    {
      paramInt = 2131436521;
      ((TextView)localObject).setText(paramInt);
      localObject = paramView.jdField_a_of_type_AndroidWidgetProgressBar;
      if (!this.jdField_a_of_type_Boolean) {
        break label830;
      }
      paramInt = 0;
      label780:
      ((ProgressBar)localObject).setVisibility(paramInt);
      paramView = paramView.jdField_a_of_type_AndroidWidgetImageView;
      if (!this.jdField_a_of_type_Boolean) {
        break label836;
      }
      paramInt = j;
      label801:
      paramView.setVisibility(paramInt);
      if (!this.jdField_a_of_type_Boolean) {
        break label841;
      }
    }
    label830:
    label836:
    label841:
    for (paramInt = i;; paramInt = 4)
    {
      paramViewGroup.setVisibility(paramInt);
      return paramViewGroup;
      paramInt = 2131433920;
      break;
      paramInt = 8;
      break label780;
      paramInt = 0;
      break label801;
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     swi
 * JD-Core Version:    0.7.0.1
 */