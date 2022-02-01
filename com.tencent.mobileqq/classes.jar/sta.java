import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.widgets.TabLayout;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;

public class sta
  extends abei<TabChannelCoverInfo>
{
  public static final String a;
  private Map<Integer, rev> jdField_a_of_type_JavaUtilMap;
  private ogh jdField_a_of_type_Ogh;
  private TabLayout b;
  
  static
  {
    jdField_a_of_type_JavaLangString = sta.class.getSimpleName();
  }
  
  public sta(Context paramContext, List<TabChannelCoverInfo> paramList, TabLayout paramTabLayout, ogh paramogh)
  {
    super(paramContext, paramList);
    this.b = paramTabLayout;
    this.jdField_a_of_type_Ogh = paramogh;
  }
  
  private void a(View... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      paramVarArgs[i].setVisibility(8);
      i += 1;
    }
  }
  
  private int b()
  {
    if (pih.a()) {
      return 11;
    }
    return 6;
  }
  
  protected int a()
  {
    return 2131560207;
  }
  
  protected void a(abej paramabej, TabChannelCoverInfo paramTabChannelCoverInfo, int paramInt)
  {
    TextView localTextView = (TextView)paramabej.a(2131379957);
    Object localObject2 = (ImageView)paramabej.a(2131369156);
    ImageView localImageView2 = (ImageView)paramabej.a(2131369159);
    Object localObject1 = (ImageView)paramabej.a(2131371647);
    a(new View[] { localTextView, localObject2, localImageView2, localObject1 });
    ImageView localImageView1 = (ImageView)paramabej.a(2131369263);
    if (paramTabChannelCoverInfo != null)
    {
      if (!TextUtils.isEmpty(paramTabChannelCoverInfo.mChannelCoverPicUrl))
      {
        localImageView2.setVisibility(0);
        localImageView2.setImageDrawable(URLDrawable.getDrawable(paramTabChannelCoverInfo.mChannelCoverPicUrl, true));
      }
      if (!TextUtils.isEmpty(paramTabChannelCoverInfo.mIconUrl)) {
        ((ImageView)localObject2).setVisibility(0);
      }
    }
    label778:
    try
    {
      ((ImageView)localObject2).setImageDrawable(URLDrawable.getDrawable(paramTabChannelCoverInfo.mIconUrl, true));
      if ((!TextUtils.isEmpty(paramTabChannelCoverInfo.mChannelCoverName)) && (paramTabChannelCoverInfo.onlyCover == 0))
      {
        localTextView.setText(paramTabChannelCoverInfo.mChannelCoverName);
        if (paramTabChannelCoverInfo.fontsColor != 0)
        {
          i = paramTabChannelCoverInfo.fontsColor;
          localTextView.setTextColor(i);
          localTextView.setVisibility(0);
        }
      }
      else
      {
        if (paramTabChannelCoverInfo.redPoint == null) {
          break label761;
        }
        localObject2 = new BusinessInfoCheckUpdate.RedTypeInfo();
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_type.set(0);
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_content.set("");
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_desc.set("");
        if (!paramTabChannelCoverInfo.redPoint.jdField_a_of_type_Boolean) {
          break label744;
        }
        long l = System.currentTimeMillis() / 1000L;
        if ((paramTabChannelCoverInfo.redPoint.c == 0L) || ((float)(l - paramTabChannelCoverInfo.redPoint.c) <= 2.5F) || ((float)(l / 3600L - paramTabChannelCoverInfo.redPoint.c / 3600L) >= 1.0F)) {
          break label615;
        }
        i = 1;
        if ((paramTabChannelCoverInfo.redPoint.jdField_a_of_type_Long > l) || ((paramTabChannelCoverInfo.redPoint.b != 0L) && (paramTabChannelCoverInfo.redPoint.b < l))) {
          break label727;
        }
        if (paramTabChannelCoverInfo.redPoint.jdField_a_of_type_Int != 0) {
          break label621;
        }
        localImageView1.setVisibility(0);
        paramabej.a().setOnClickListener(new stb(this, paramInt, paramTabChannelCoverInfo, localImageView1));
        if (this.b != null)
        {
          i = this.b.getFirstVisiblePosition();
          int j = this.b.getLastVisiblePosition();
          if ((paramInt >= i) && (paramInt <= j) && (this.jdField_a_of_type_JavaUtilMap != null))
          {
            localObject1 = new rgg();
            ((rev)localObject1).a = paramTabChannelCoverInfo;
            ((rev)localObject1).l = paramInt;
            this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramTabChannelCoverInfo.mChannelCoverId), localObject1);
          }
        }
        if (this.jdField_a_of_type_Ogh != null)
        {
          paramabej = paramabej.a(2131368840);
          if (paramInt != this.jdField_a_of_type_Ogh.c()) {
            break label778;
          }
          localTextView.setTextColor(localTextView.getResources().getColor(2131166879));
          localTextView.setTypeface(Typeface.defaultFromStyle(1));
          paramabej.setVisibility(0);
          if (this.jdField_a_of_type_Ogh.a() == 0)
          {
            paramTabChannelCoverInfo = (ViewGroup.MarginLayoutParams)paramabej.getLayoutParams();
            paramTabChannelCoverInfo.leftMargin = bgtn.b(0.0F);
            paramTabChannelCoverInfo.rightMargin = bgtn.b(0.0F);
            paramabej.setLayoutParams(paramTabChannelCoverInfo);
          }
        }
        return;
      }
    }
    catch (Exception localException)
    {
      label727:
      for (;;)
      {
        int i;
        label615:
        label744:
        if (QLog.isColorLevel())
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "load channel cover error : " + localException);
          continue;
          i = -16777216;
          continue;
          i = 0;
          continue;
          label621:
          if ((paramInt < b()) && (i == 0))
          {
            if (ogh.b)
            {
              ((ImageView)localObject1).setVisibility(0);
              TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 1.0F, 1, -1.0F, 1, -1.0F, 1, 1.0F);
              localTranslateAnimation.setDuration(3000L);
              localTranslateAnimation.setRepeatCount(1);
              localTranslateAnimation.setStartOffset(1000L);
              localTranslateAnimation.setFillAfter(true);
              ((ImageView)localObject1).startAnimation(localTranslateAnimation);
            }
            paramTabChannelCoverInfo.redPoint.c = (System.currentTimeMillis() / 1000L);
            this.jdField_a_of_type_Ogh.a(paramTabChannelCoverInfo);
            continue;
            localImageView1.setVisibility(8);
            ((ImageView)localObject1).setVisibility(8);
            continue;
            localImageView1.setVisibility(8);
            ((ImageView)localObject1).setVisibility(8);
            continue;
            label761:
            localImageView1.setVisibility(8);
            ((ImageView)localObject1).setVisibility(8);
            continue;
            localTextView.setTextColor(localTextView.getResources().getColor(2131166880));
            localTextView.setTypeface(Typeface.defaultFromStyle(0));
            paramabej.setVisibility(4);
          }
        }
      }
    }
  }
  
  public void a(Map<Integer, rev> paramMap)
  {
    this.jdField_a_of_type_JavaUtilMap = paramMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sta
 * JD-Core Version:    0.7.0.1
 */