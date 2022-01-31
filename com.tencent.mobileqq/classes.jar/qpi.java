import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyDraftboxItem;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyDraftboxItem.PicData;
import com.tencent.biz.pubaccount.readinjoy.view.MiddleBracketsTitleTextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.hotpic.HotVideoData;
import java.io.File;
import java.util.List;

public class qpi
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List<ReadInJoyDraftboxItem> jdField_a_of_type_JavaUtilList;
  private pgo jdField_a_of_type_Pgo = owy.a().a();
  
  public qpi(Context paramContext, List<ReadInJoyDraftboxItem> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private int a(ReadInJoyDraftboxItem paramReadInJoyDraftboxItem)
  {
    if (paramReadInJoyDraftboxItem.type == 0) {
      return 1;
    }
    if (paramReadInJoyDraftboxItem.type == 1) {
      return 4;
    }
    if (paramReadInJoyDraftboxItem.type == 2) {
      return 3;
    }
    if (paramReadInJoyDraftboxItem.type == 3) {
      return 6;
    }
    return 5;
  }
  
  private URLDrawable.URLDrawableOptions a()
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mUseAutoScaleParams = false;
    localURLDrawableOptions.mRequestWidth = bdoo.b(100.0F);
    localURLDrawableOptions.mRequestHeight = bdoo.b(100.0F);
    return localURLDrawableOptions;
  }
  
  private URLDrawable a(HotPicData paramHotPicData)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    boolean bool;
    if (paramHotPicData.getDataType() != 2)
    {
      bool = true;
      localURLDrawableOptions.mPlayGifImage = bool;
      localURLDrawableOptions.mExtraInfo = paramHotPicData;
      localURLDrawableOptions.mRequestWidth = bdoo.a(50.0F);
      localURLDrawableOptions.mRequestHeight = bdoo.a(50.0F);
      if (paramHotPicData.getDataType() != 2) {
        break label69;
      }
    }
    label69:
    for (paramHotPicData = asvr.a((HotVideoData)paramHotPicData);; paramHotPicData = astt.a(paramHotPicData.url))
    {
      if (paramHotPicData != null) {
        break label80;
      }
      return null;
      bool = false;
      break;
    }
    label80:
    return URLDrawable.getDrawable(paramHotPicData, localURLDrawableOptions);
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
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131560005, null);
    }
    Object localObject2 = (TextView)paramViewGroup.findViewById(2131378759);
    MiddleBracketsTitleTextView localMiddleBracketsTitleTextView = (MiddleBracketsTitleTextView)paramViewGroup.findViewById(2131378757);
    paramView = (TextView)paramViewGroup.findViewById(2131378758);
    ImageView localImageView = (ImageView)paramViewGroup.findViewById(2131368765);
    TextView localTextView = (TextView)paramViewGroup.findViewById(2131378736);
    ((TextView)localObject2).setEditableFactory(bamz.a);
    localMiddleBracketsTitleTextView.setEditableFactory(bamz.a);
    ReadInJoyDraftboxItem localReadInJoyDraftboxItem;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()))
    {
      localReadInJoyDraftboxItem = (ReadInJoyDraftboxItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramView.setText(orr.a(localReadInJoyDraftboxItem.time, false));
      paramView = localReadInJoyDraftboxItem.title;
      if (localReadInJoyDraftboxItem.type == 3) {
        paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131718991);
      }
      if (TextUtils.isEmpty(paramView)) {
        break label487;
      }
      Object localObject1 = paramView;
      if (localReadInJoyDraftboxItem.type == 2) {
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131718987) + ": " + paramView;
      }
      ((TextView)localObject2).setText(new bamp((CharSequence)localObject1, 7, 16));
      ((TextView)localObject2).setVisibility(0);
      localObject1 = localReadInJoyDraftboxItem.digest;
      paramView = (View)localObject1;
      if (localReadInJoyDraftboxItem.type == 3)
      {
        paramView = (View)localObject1;
        if (!TextUtils.isEmpty(localReadInJoyDraftboxItem.title))
        {
          localObject2 = "[" + localReadInJoyDraftboxItem.title + "]";
          paramView = (String)localObject2 + (String)localObject1;
          localMiddleBracketsTitleTextView.setTitle((String)localObject2);
          localMiddleBracketsTitleTextView.setNeedAddBrackets(true);
        }
      }
      if (TextUtils.isEmpty(paramView)) {
        break label497;
      }
      localMiddleBracketsTitleTextView.setText(new bamp(paramView, 7, 16));
      localMiddleBracketsTitleTextView.setVisibility(0);
      label373:
      if ((localReadInJoyDraftboxItem.firstPicData == null) || ((localReadInJoyDraftboxItem.firstPicData.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData == null) && (TextUtils.isEmpty(localReadInJoyDraftboxItem.firstPicData.jdField_a_of_type_JavaLangString)))) {
        break label593;
      }
      localImageView.setVisibility(0);
      if (localReadInJoyDraftboxItem.firstPicData.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData == null) {
        break label507;
      }
      localImageView.setImageDrawable(a(localReadInJoyDraftboxItem.firstPicData.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData));
    }
    label593:
    for (;;)
    {
      paramViewGroup.setOnClickListener(new qpj(this, localReadInJoyDraftboxItem));
      localTextView.setOnClickListener(new qpk(this, localReadInJoyDraftboxItem, paramInt));
      paramViewGroup.setTag(-3, Integer.valueOf(bdoo.a(66.0F)));
      return paramViewGroup;
      label487:
      ((TextView)localObject2).setVisibility(8);
      break;
      label497:
      localMiddleBracketsTitleTextView.setVisibility(8);
      break label373;
      label507:
      if (localReadInJoyDraftboxItem.firstPicData.jdField_a_of_type_Int == 1)
      {
        paramView = new File(localReadInJoyDraftboxItem.firstPicData.jdField_a_of_type_JavaLangString);
        if (paramView.exists()) {
          localImageView.setImageDrawable(URLDrawable.getDrawable(paramView, a()));
        }
      }
      else if (localReadInJoyDraftboxItem.firstPicData.jdField_a_of_type_Int == 2)
      {
        localImageView.setImageDrawable(URLDrawable.getDrawable(localReadInJoyDraftboxItem.firstPicData.jdField_a_of_type_JavaLangString, a()));
        continue;
        localImageView.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qpi
 * JD-Core Version:    0.7.0.1
 */