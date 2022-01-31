package dov.com.tencent.biz.qqstory.takevideo;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import aocf;
import aocg;
import aoch;
import aoci;
import aocj;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.RoundedTransformation;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.ElasticImageView;
import dov.com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@TargetApi(13)
public class EditVideoFragment
  extends EditVideoPart
{
  public static final int[] a;
  public static final int[] b;
  private int jdField_a_of_type_Int;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  public RelativeLayout a;
  private aoci jdField_a_of_type_Aoci;
  public ElasticImageView a;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean jdField_a_of_type_Boolean = true;
  private ImageView[] jdField_a_of_type_ArrayOfAndroidWidgetImageView;
  private RelativeLayout[] jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout;
  private int jdField_b_of_type_Int;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131371758, 2131371761, 2131371764, 2131371767, 2131371770, 2131371773 };
    jdField_b_of_type_ArrayOfInt = new int[] { 2131371757, 2131371760, 2131371763, 2131371766, 2131371769, 2131371772 };
  }
  
  public EditVideoFragment(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
  }
  
  private void a(List paramList)
  {
    int i;
    int j;
    if (paramList == null)
    {
      i = 0;
      j = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.c();
      SLog.b("Q.qqstory.record.EditVideoFragment", "initValidFragmentInfo.fragmentCount=%d. expectFragmentCount = %d. ", Integer.valueOf(i), Integer.valueOf(j));
      if (i <= j) {
        break label428;
      }
      i = j;
    }
    label428:
    for (;;)
    {
      if ((i < 1) || (i > 6))
      {
        throw new IllegalStateException("initValidFragmentInfo error. fragments's count is illegal.");
        i = paramList.size();
        break;
      }
      this.jdField_a_of_type_JavaUtilList.clear();
      if (i == 1)
      {
        this.jdField_a_of_type_JavaUtilList.add(new aocj((VideoFragmentInfo)paramList.get(0), null, null));
        return;
      }
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.d()) {}
      int k;
      int m;
      RoundedTransformation localRoundedTransformation;
      VideoFragmentInfo localVideoFragmentInfo;
      for (Object localObject = "0";; localObject = "1")
      {
        StoryReportor.a("video_edit", "edit_over", 0, 0, new String[] { String.valueOf(i), localObject });
        if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.d()) && ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a instanceof EditLocalVideoSource)))
        {
          localObject = (EditLocalVideoSource)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a;
          StoryReportor.a("video_edit", "edit_spilt", 0, 0, new String[] { String.valueOf(Math.ceil((((EditLocalVideoSource)localObject).jdField_b_of_type_Int - ((EditLocalVideoSource)localObject).jdField_a_of_type_Int) / 1000.0F)) });
        }
        j = AIOUtils.a(15.0F, a());
        k = AIOUtils.a(12.0F, a());
        m = AIOUtils.a(2.0F, a());
        k = (ScreenUtil.jdField_a_of_type_Int - j * 2 - k * 5) / 6 - m * 2;
        m = k * 8 / 5;
        localRoundedTransformation = new RoundedTransformation(AIOUtils.a(3.0F, a()), 0, m * 1.0F / k, null, null);
        j = 0;
        while (j < i)
        {
          localVideoFragmentInfo = (VideoFragmentInfo)paramList.get(j);
          if (localVideoFragmentInfo != null) {
            break label368;
          }
          j += 1;
        }
        break;
      }
      label368:
      localObject = BitmapUtils.a(localVideoFragmentInfo.jdField_c_of_type_AndroidGraphicsBitmap, k, m, false);
      if (localObject != null) {}
      for (localObject = localRoundedTransformation.a((Bitmap)localObject);; localObject = null)
      {
        this.jdField_a_of_type_JavaUtilList.add(new aocj(localVideoFragmentInfo, (Bitmap)localObject, null));
        break;
      }
    }
  }
  
  private void a(List paramList, boolean paramBoolean)
  {
    int j = 0;
    if (paramList == null)
    {
      SLog.c("Q.qqstory.record.EditVideoFragment", "updateValidFragmentThumb error. fragmentInfos=null.");
      return;
    }
    if (this.jdField_a_of_type_Aoci == null) {
      this.jdField_a_of_type_Aoci = new aoci(this);
    }
    int i;
    if (paramBoolean)
    {
      i = 0;
      label40:
      if (i >= paramList.size()) {
        break label338;
      }
      if (((VideoFragmentInfo)paramList.get(i)).jdField_c_of_type_Int != this.jdField_b_of_type_Int) {}
    }
    for (;;)
    {
      if (i < 0)
      {
        SLog.e("Q.qqstory.record.EditVideoFragment", "can't find new fragment data to update.");
        return;
        i += 1;
        break label40;
      }
      do
      {
        j += 1;
        if (j >= this.jdField_a_of_type_JavaUtilList.size()) {
          break;
        }
      } while (((aocj)this.jdField_a_of_type_JavaUtilList.get(j)).jdField_c_of_type_Int != this.jdField_b_of_type_Int);
      SLog.b("Q.qqstory.record.EditVideoFragment", "update the %d fragment's thumb.", Integer.valueOf(j));
      this.jdField_a_of_type_Aoci.a((VideoFragmentInfo)paramList.get(i), (aocj)this.jdField_a_of_type_JavaUtilList.get(j));
      return;
      i = 0;
      while (i < paramList.size())
      {
        j = 0;
        if (j < this.jdField_a_of_type_JavaUtilList.size())
        {
          if ((paramList.get(i) == null) || (this.jdField_a_of_type_JavaUtilList.get(j) == null)) {
            SLog.b("Q.qqstory.record.EditVideoFragment", "updateValidFragmentThumb error. fragmentInfos.get(%d) == null or mValidFragmentInfo.get(%d) == null.", Integer.valueOf(i), Integer.valueOf(j));
          }
          while (((VideoFragmentInfo)paramList.get(i)).jdField_c_of_type_Int != ((aocj)this.jdField_a_of_type_JavaUtilList.get(j)).jdField_c_of_type_Int)
          {
            j += 1;
            break;
          }
          SLog.b("Q.qqstory.record.EditVideoFragment", "updateValidFragmentThumb. update mValidFragmentInfo.get(%d)", Integer.valueOf(j));
          this.jdField_a_of_type_Aoci.a((VideoFragmentInfo)paramList.get(i), (aocj)this.jdField_a_of_type_JavaUtilList.get(j));
        }
        i += 1;
      }
      break;
      label338:
      i = -1;
    }
  }
  
  private void b(List paramList)
  {
    int j = 0;
    if (paramList == null) {}
    for (int i = 0; (i < 2) || (i > 6); i = paramList.size())
    {
      SLog.e("Q.qqstory.record.EditVideoFragment", "initViewStub error. fragmentCount=%d.", new Object[] { Integer.valueOf(i) });
      return;
    }
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      SLog.e("Q.qqstory.record.EditVideoFragment", "initViewStub error. hasInitViewStub=%s.", new Object[] { Boolean.valueOf(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) });
      return;
    }
    SLog.b("Q.qqstory.record.EditVideoFragment", "initViewStub. fragmentCount = %d.", Integer.valueOf(i));
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout == null)
    {
      this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131364441));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewStub.inflate());
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131364395));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetElasticImageView = ((ElasticImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131364396));
    this.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout = new RelativeLayout[6];
    i = 0;
    while (i < this.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout.length)
    {
      this.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i] = ((RelativeLayout)a(jdField_b_of_type_ArrayOfInt[i]));
      i += 1;
    }
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView = new ImageView[6];
    i = j;
    while (i < this.jdField_a_of_type_ArrayOfAndroidWidgetImageView.length)
    {
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i] = ((ImageView)a(jdField_a_of_type_ArrayOfInt[i]));
      i += 1;
    }
    c(paramList);
    d(paramList);
  }
  
  private void c(int paramInt)
  {
    if (this.jdField_a_of_type_Aoci == null) {
      this.jdField_a_of_type_Aoci = new aoci(this);
    }
    int i = 0;
    for (;;)
    {
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        if (paramInt == ((aocj)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_c_of_type_Int)
        {
          SLog.b("Q.qqstory.record.EditVideoFragment", "updateValidFragmentDoodleByBlockIndex. update mValidFragmentInfo.get(%d)", Integer.valueOf(i));
          ((aocj)this.jdField_a_of_type_JavaUtilList.get(i)).a = this.jdField_a_of_type_Aoci.a(paramInt);
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
  
  private void c(List paramList)
  {
    if (paramList == null) {}
    for (int i = 0; (i < 2) || (i > 6); i = paramList.size())
    {
      SLog.e("Q.qqstory.record.EditVideoFragment", "initFragmentButton error. fragmentCount is invalid.");
      return;
    }
    int k = AIOUtils.a(15.0F, a());
    int m = AIOUtils.a(12.0F, a());
    int j = AIOUtils.a(2.0F, a());
    int n = (ScreenUtil.jdField_a_of_type_Int - k * 2 - m * 5) / 6;
    int i1 = (n - j * 2) * 8 / 5 + j * 2;
    int i2 = AIOUtils.a(102.0F, a());
    j = 0;
    while (j < this.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout.length)
    {
      paramList = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[j].getLayoutParams();
      paramList.width = n;
      paramList.height = i1;
      paramList.bottomMargin = i2;
      paramList.leftMargin = k;
      this.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[j].setLayoutParams(paramList);
      k += n + m;
      j += 1;
    }
    SLog.b("Q.qqstory.record.EditVideoFragment", "initFragmentButton. fragmentCount = %d, fragmentWidth = %d, fragmentHeight = %d.", Integer.valueOf(i), Integer.valueOf(n), Integer.valueOf(i1));
  }
  
  private void d(List paramList)
  {
    int j = 0;
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      SLog.e("Q.qqstory.record.EditVideoFragment", "setFragmentListener error. hasInitViewStub = %s.", new Object[] { Boolean.valueOf(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) });
    }
    for (;;)
    {
      return;
      if (paramList == null) {}
      for (int i = 0; (i < 2) || (i > 6); i = paramList.size())
      {
        SLog.e("Q.qqstory.record.EditVideoFragment", "setFragmentListener error. fragmentCount is invalid.");
        return;
      }
      SLog.b("Q.qqstory.record.EditVideoFragment", "setFragmentListener. fragmentCount = %d.", Integer.valueOf(i));
      i = j;
      while (i < paramList.size())
      {
        this.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i].setOnTouchListener(new aoch(this, i));
        i += 1;
      }
    }
  }
  
  private void e(List paramList)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      SLog.e("Q.qqstory.record.EditVideoFragment", "updateFragmentVisibility error. hasInitViewStub = %s.", new Object[] { Boolean.valueOf(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) });
      return;
    }
    if (paramList == null) {}
    for (int i = 0;; i = paramList.size())
    {
      SLog.b("Q.qqstory.record.EditVideoFragment", "updateFragmentVisibility. list.size() = %d.", Integer.valueOf(i));
      if (paramList != null) {
        break;
      }
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
    }
    if (paramList.size() <= 1)
    {
      this.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[0].setVisibility(8);
      this.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[1].setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    i = 0;
    label130:
    if (i < this.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout.length)
    {
      if (i >= paramList.size()) {
        break label217;
      }
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i].setBackgroundDrawable(new BitmapDrawable(((aocj)paramList.get(i)).b));
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i].setImageBitmap(((aocj)paramList.get(i)).a);
      this.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i].setVisibility(0);
    }
    for (;;)
    {
      i += 1;
      break label130;
      break;
      label217:
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i].setBackgroundColor(0);
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i].setImageBitmap(null);
      this.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i].setVisibility(8);
      this.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i].setOnTouchListener(null);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(int paramInt)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      SLog.e("Q.qqstory.record.EditVideoFragment", "selectFragment error. hasInitViewStub = %s.", new Object[] { Boolean.valueOf(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) });
      return;
    }
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size()))
    {
      SLog.e("Q.qqstory.record.EditVideoFragment", "selectFragment error. invalid index.");
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList.get(paramInt) == null)
    {
      SLog.e("Q.qqstory.record.EditVideoFragment", "selectFragment error. fragmentInfo is null!");
      return;
    }
    if ((this.jdField_a_of_type_Int == ((aocj)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_c_of_type_Int) && (!this.jdField_a_of_type_Boolean))
    {
      SLog.e("Q.qqstory.record.EditVideoFragment", "selectFragment error. the same index!");
      return;
    }
    int i = 0;
    if (i < this.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout.length)
    {
      if (i == paramInt) {
        this.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i].setBackgroundResource(2130843844);
      }
      for (;;)
      {
        i += 1;
        break;
        this.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i].setBackgroundResource(0);
      }
    }
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = ((aocj)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_c_of_type_Int;
    if (!this.jdField_a_of_type_Boolean)
    {
      SLog.b("Q.qqstory.record.EditVideoFragment", "send message. selected card index = %d. selected fragment index change form %d to %d.", Integer.valueOf(paramInt), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_a_of_type_Int));
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(Message.obtain(null, 6, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int));
      c(this.jdField_b_of_type_Int);
      e(this.jdField_a_of_type_JavaUtilList);
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 >= this.jdField_a_of_type_JavaUtilList.size()) || (paramInt1 < 0))
    {
      SLog.e("Q.qqstory.record.EditVideoFragment", "deleteFragment error. cardIndex=%d.", new Object[] { Integer.valueOf(paramInt1) });
      return;
    }
    Object localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[paramInt1].getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = paramInt3;
    ((RelativeLayout.LayoutParams)localObject).leftMargin = paramInt2;
    this.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[paramInt1].setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (VideoFragmentInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt1);
    if (localObject == null)
    {
      SLog.e("Q.qqstory.record.EditVideoFragment", "deleteFragment error. VideoFragmentInfo = null.");
      return;
    }
    paramInt2 = ((VideoFragmentInfo)localObject).jdField_c_of_type_Int;
    this.jdField_a_of_type_JavaUtilList.remove(paramInt1);
    e(this.jdField_a_of_type_JavaUtilList);
    SLog.b("Q.qqstory.record.EditVideoFragment", "send message. deleted card index = %d. deleted fragment index = %d.", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(Message.obtain(null, 7, paramInt2, 0));
    EditVideoPartManager localEditVideoPartManager = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.d()) {}
    for (localObject = "0";; localObject = "1")
    {
      localEditVideoPartManager.b("clk_del", 0, 0, new String[] { "", localObject });
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    switch (paramInt2)
    {
    case 5: 
    case 11: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    case 22: 
    case 23: 
    case 25: 
    case 26: 
    case 27: 
    case 28: 
    case 29: 
    case 30: 
    case 31: 
    case 32: 
    case 33: 
    case 35: 
    case 36: 
    default: 
    case 0: 
    case 10: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 24: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 6: 
    case 9: 
    case 12: 
    case 34: 
    case 37: 
      do
      {
        do
        {
          return;
        } while (this.jdField_b_of_type_AndroidWidgetRelativeLayout == null);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        return;
      } while (this.jdField_b_of_type_AndroidWidgetRelativeLayout == null);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      return;
    case 7: 
      if (paramInt1 == 8)
      {
        if ((paramObject != null) && ((paramObject instanceof Boolean)))
        {
          a(true, true, ((Boolean)paramObject).booleanValue());
          return;
        }
        a(true, true, true);
        return;
      }
      a(true, false, true);
      return;
    }
    if ((paramObject != null) && ((paramObject instanceof Boolean)))
    {
      a(false, ((Boolean)paramObject).booleanValue(), true);
      return;
    }
    a(false, true, true);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > 6)
    {
      SLog.e("Q.qqstory.record.EditVideoFragment", "setOthersVisibility error. mValidFragmentInfo's size is out of bound!");
      return;
    }
    int i = 0;
    label25:
    RelativeLayout localRelativeLayout;
    if (i < this.jdField_a_of_type_JavaUtilList.size()) {
      if (i != paramInt)
      {
        localRelativeLayout = this.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i];
        if (!paramBoolean) {
          break label72;
        }
      }
    }
    label72:
    for (int j = 0;; j = 4)
    {
      localRelativeLayout.setVisibility(j);
      i += 1;
      break label25;
      break;
    }
  }
  
  public void a(View paramView)
  {
    SLog.c("Q.qqstory.record.EditVideoFragment", "startClickAnimation.");
    ScaleAnimation localScaleAnimation1 = new ScaleAnimation(1.0F, 0.85F, 1.0F, 0.85F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation1.setDuration(100L);
    ScaleAnimation localScaleAnimation2 = new ScaleAnimation(1.0F, 1.176471F, 1.0F, 1.176471F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation2.setStartOffset(100L);
    localScaleAnimation2.setDuration(100L);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.setInterpolator(new LinearInterpolator());
    localAnimationSet.addAnimation(localScaleAnimation1);
    localAnimationSet.addAnimation(localScaleAnimation2);
    localAnimationSet.setFillAfter(false);
    paramView.startAnimation(localAnimationSet);
  }
  
  @TargetApi(11)
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    SLog.b("Q.qqstory.record.EditVideoFragment", "startResetAnimaton. sMarginLeft=%d, sMarginBottom=%d, dMarginLeft=%d, dMarginBottom=%d.", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4));
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.setDuration(200L);
    localValueAnimator.setInterpolator(new DecelerateInterpolator());
    localValueAnimator.addListener(new aocf(this, paramView));
    localValueAnimator.addUpdateListener(new aocg(this, paramInt3, paramInt1, paramInt4, paramInt2, paramView));
    localValueAnimator.start();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
    {
      if (!paramBoolean2) {
        break label33;
      }
      if (paramBoolean1) {
        TakeVideoUtils.b(this.jdField_b_of_type_AndroidWidgetRelativeLayout, paramBoolean3);
      }
    }
    else
    {
      return;
    }
    TakeVideoUtils.a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, paramBoolean3);
    return;
    label33:
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setAnimation(null);
    RelativeLayout localRelativeLayout = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
    if (paramBoolean1) {}
    for (int i = 0;; i = 8)
    {
      localRelativeLayout.setVisibility(i);
      return;
    }
  }
  
  protected boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 9: 
    case 10: 
    default: 
      return super.a(paramMessage);
    case 8: 
      SLog.c("Q.qqstory.record.EditVideoFragment", "receive message.");
      paramMessage = (EditVideoPlayerExport)a(EditVideoPlayerExport.class);
      if (paramMessage == null) {
        break;
      }
    }
    for (paramMessage = paramMessage.a();; paramMessage = null)
    {
      if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        a(paramMessage);
        b(this.jdField_a_of_type_JavaUtilList);
        e(this.jdField_a_of_type_JavaUtilList);
        a(0);
        return true;
      }
      if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.d()) {}
      for (boolean bool = true;; bool = false)
      {
        a(paramMessage, bool);
        e(this.jdField_a_of_type_JavaUtilList);
        return true;
      }
      this.c = ((Long)paramMessage.obj).longValue();
      return true;
    }
  }
  
  public void b(int paramInt)
  {
    int i = paramInt;
    if (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) {
      i = 0;
    }
    SLog.b("Q.qqstory.record.EditVideoFragment", "selectNextFragment. nextCardIndex = %d.", Integer.valueOf(i));
    a(i);
  }
  
  public void b(View paramView)
  {
    SLog.c("Q.qqstory.record.EditVideoFragment", "startDargAnimator.");
    paramView.clearAnimation();
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 1.2F, 1.0F, 1.2F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(100L);
    localScaleAnimation.setInterpolator(new LinearInterpolator());
    localScaleAnimation.setFillAfter(true);
    paramView.startAnimation(localScaleAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoFragment
 * JD-Core Version:    0.7.0.1
 */