package dov.com.qq.im.ae.biz.qcircle.part;

import android.graphics.Typeface;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.AEReportUtils;
import dov.com.qq.im.ae.biz.qcircle.AECirclePhotoListLogic;
import dov.com.qq.im.ae.biz.qcircle.AECircleSinglePhotoListFragment;
import dov.com.qq.im.ae.biz.qcircle.event.AECircleSelectChangeEvent;
import dov.com.qq.im.ae.biz.qcircle.part.base.AECircleBasePart;
import dov.com.qq.im.ae.view.NoScrollViewPager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AECirclePhotoListPart
  extends AECircleBasePart
  implements CompoundButton.OnCheckedChangeListener, SimpleEventReceiver
{
  private RadioButton jdField_a_of_type_AndroidWidgetRadioButton;
  private RadioGroup jdField_a_of_type_AndroidWidgetRadioGroup;
  private NoScrollViewPager jdField_a_of_type_DovComQqImAeViewNoScrollViewPager;
  private ArrayList<AECircleSinglePhotoListFragment> jdField_a_of_type_JavaUtilArrayList;
  private RadioButton b;
  private RadioButton c;
  
  public AECirclePhotoListPart(AECirclePhotoListLogic paramAECirclePhotoListLogic)
  {
    super(paramAECirclePhotoListLogic);
    this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a(this);
  }
  
  private void a(int paramInt)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (i == paramInt) {
        ((AECircleSinglePhotoListFragment)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a(paramInt);
      }
      for (;;)
      {
        i += 1;
        break;
        ((AECircleSinglePhotoListFragment)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a();
      }
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilArrayList.add(new AECircleSinglePhotoListFragment().a(this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic).a(1));
    this.jdField_a_of_type_JavaUtilArrayList.add(new AECircleSinglePhotoListFragment().a(this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic).a(2));
    this.jdField_a_of_type_JavaUtilArrayList.add(new AECircleSinglePhotoListFragment().a(this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic).a(3));
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetRadioButton.setTypeface(Typeface.DEFAULT_BOLD);
    this.jdField_a_of_type_AndroidWidgetRadioGroup.setOnCheckedChangeListener(new AECirclePhotoListPart.1(this));
    this.jdField_a_of_type_DovComQqImAeViewNoScrollViewPager.addOnPageChangeListener(new AECirclePhotoListPart.2(this));
  }
  
  public String a()
  {
    return "AECirclePhotoListPart";
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((AECircleSinglePhotoListFragment)localIterator.next()).b();
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    b();
    this.jdField_a_of_type_DovComQqImAeViewNoScrollViewPager = ((NoScrollViewPager)paramView.findViewById(2131371995));
    this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)paramView.findViewById(2131377038));
    this.jdField_a_of_type_AndroidWidgetRadioButton = ((RadioButton)paramView.findViewById(2131376487));
    this.b = ((RadioButton)paramView.findViewById(2131376489));
    this.c = ((RadioButton)paramView.findViewById(2131376491));
    this.jdField_a_of_type_AndroidWidgetRadioButton.setOnCheckedChangeListener(this);
    this.b.setOnCheckedChangeListener(this);
    this.c.setOnCheckedChangeListener(this);
    this.jdField_a_of_type_DovComQqImAeViewNoScrollViewPager.setOffscreenPageLimit(2);
    paramView = new AECirclePhotoListPart.PhotoPagerAdapter(this, a());
    this.jdField_a_of_type_DovComQqImAeViewNoScrollViewPager.setAdapter(paramView);
    c();
  }
  
  public void a(List<LocalMediaInfo> paramList)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((AECircleSinglePhotoListFragment)localIterator.next()).a(paramList);
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(AECircleSelectChangeEvent.class);
    return localArrayList;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = Typeface.DEFAULT_BOLD;
      paramCompoundButton.setTypeface((Typeface)localObject);
      if (!this.jdField_a_of_type_AndroidWidgetRadioButton.isChecked()) {
        break label46;
      }
      localObject = "1";
    }
    for (;;)
    {
      AEReportUtils.a((String)localObject);
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      localObject = Typeface.DEFAULT;
      break;
      label46:
      if (this.b.isChecked()) {
        localObject = "2";
      } else {
        localObject = "3";
      }
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof AECircleSelectChangeEvent)) {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.part.AECirclePhotoListPart
 * JD-Core Version:    0.7.0.1
 */