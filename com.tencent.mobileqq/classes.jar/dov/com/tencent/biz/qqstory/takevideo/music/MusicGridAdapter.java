package dov.com.tencent.biz.qqstory.takevideo.music;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.ArrayList;

public class MusicGridAdapter
  extends BaseAdapter
{
  protected static int a;
  protected static int b;
  protected static int c;
  protected Context a;
  protected GridView a;
  protected QQStoryMusicInfo a;
  protected ArrayList a;
  protected boolean a;
  protected ArrayList b;
  
  public MusicGridAdapter(Context paramContext, GridView paramGridView, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidWidgetGridView = paramGridView;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    paramContext = this.jdField_a_of_type_AndroidContentContext.getResources();
    jdField_a_of_type_Int = AIOUtils.a(90.0F, paramContext);
    jdField_b_of_type_Int = AIOUtils.a(10.0F, paramContext);
    c = AIOUtils.a(5.0F, paramContext);
    this.jdField_a_of_type_AndroidWidgetGridView.setColumnWidth(jdField_a_of_type_Int);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList.add(QQStoryMusicInfo.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo);
    if (!paramBoolean1) {
      this.jdField_b_of_type_JavaUtilArrayList.add(QQStoryMusicInfo.jdField_b_of_type_DovComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo);
    }
    if (paramBoolean2) {
      this.jdField_b_of_type_JavaUtilArrayList.add(QQStoryMusicInfo.c);
    }
  }
  
  public int a()
  {
    return this.jdField_b_of_type_JavaUtilArrayList.size();
  }
  
  protected int a(QQStoryMusicInfo paramQQStoryMusicInfo)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      return this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramQQStoryMusicInfo);
    }
    return -1;
  }
  
  protected QQStoryMusicInfo a()
  {
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo;
  }
  
  public void a()
  {
    int j = 0;
    int i = j;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      i = j;
      if (this.jdField_a_of_type_JavaUtilArrayList.contains(QQStoryMusicInfo.c))
      {
        this.jdField_a_of_type_JavaUtilArrayList.remove(QQStoryMusicInfo.c);
        this.jdField_b_of_type_JavaUtilArrayList.remove(QQStoryMusicInfo.c);
        i = 1;
      }
    }
    if (i != 0) {
      notifyDataSetChanged();
    }
  }
  
  public void a(QQStoryMusicInfo paramQQStoryMusicInfo)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo = paramQQStoryMusicInfo;
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    if (paramArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    }
    this.jdField_a_of_type_JavaUtilArrayList.addAll(0, this.jdField_b_of_type_JavaUtilArrayList);
    int i = getCount();
    this.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(i);
    paramArrayList = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetGridView.getLayoutParams();
    int j = jdField_a_of_type_Int;
    paramArrayList.width = ((i - 1) * jdField_b_of_type_Int + j * i + this.jdField_a_of_type_AndroidWidgetGridView.getPaddingLeft() + this.jdField_a_of_type_AndroidWidgetGridView.getPaddingRight());
    this.jdField_a_of_type_AndroidWidgetGridView.setLayoutParams(paramArrayList);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    QQStoryMusicInfo localQQStoryMusicInfo = (QQStoryMusicInfo)getItem(paramInt);
    if (localQQStoryMusicInfo == null) {
      return null;
    }
    TextView localTextView;
    Object localObject;
    if (paramView == null)
    {
      localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      localTextView.setGravity(17);
      localTextView.setSingleLine();
      localTextView.setTextSize(12.0F);
      localTextView.setLayoutParams(new AbsListView.LayoutParams(jdField_a_of_type_Int, jdField_a_of_type_Int));
      localTextView.setPadding(c, jdField_b_of_type_Int * 2, c, 0);
      localTextView.setEllipsize(TextUtils.TruncateAt.END);
      localObject = localTextView;
      localTextView.setText(localQQStoryMusicInfo.jdField_b_of_type_JavaLangString);
      if (localQQStoryMusicInfo.jdField_b_of_type_Int != 0) {
        break label215;
      }
      localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130843580, 0, 0);
      if (localQQStoryMusicInfo.equals(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo)) {
        localTextView.getCompoundDrawables()[1].setColorFilter(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131493442), PorterDuff.Mode.MULTIPLY);
      }
      localTextView.setTag(null);
    }
    for (;;)
    {
      label644:
      label669:
      if (localQQStoryMusicInfo.equals(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo))
      {
        localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131493768));
        return localObject;
        localTextView = (TextView)paramView;
        localObject = paramView;
        break;
        label215:
        if (localQQStoryMusicInfo.jdField_b_of_type_Int == 1)
        {
          localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130843584, 0, 0);
          if (localQQStoryMusicInfo.equals(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo)) {
            localTextView.getCompoundDrawables()[1].setColorFilter(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131493442), PorterDuff.Mode.MULTIPLY);
          }
          localTextView.setTag(null);
        }
        else if (localQQStoryMusicInfo.jdField_b_of_type_Int == 2)
        {
          localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130843577, 0, 0);
          if (localQQStoryMusicInfo.equals(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo)) {
            localTextView.getCompoundDrawables()[1].setColorFilter(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131493442), PorterDuff.Mode.MULTIPLY);
          }
          localTextView.setTag(null);
        }
        else
        {
          Resources localResources;
          if (localQQStoryMusicInfo.jdField_b_of_type_Int == 4)
          {
            paramView = null;
            paramInt = (int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 36.0F);
            if (localQQStoryMusicInfo.jdField_a_of_type_Int > 0)
            {
              paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(localQQStoryMusicInfo.jdField_a_of_type_Int);
              paramView.setBounds(0, 0, paramInt, paramInt);
              localTextView.setCompoundDrawables(null, paramView, null, null);
            }
            for (;;)
            {
              if (!localQQStoryMusicInfo.equals(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo)) {
                break label644;
              }
              localTextView.getCompoundDrawables()[1].setColorFilter(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131493767), PorterDuff.Mode.SRC_ATOP);
              break;
              localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
              for (;;)
              {
                try
                {
                  paramViewGroup = localQQStoryMusicInfo.h;
                  if (TextUtils.isEmpty(paramViewGroup)) {
                    continue;
                  }
                  localFile = new File(paramViewGroup);
                  if ((!localFile.exists()) || (!localFile.isFile())) {
                    continue;
                  }
                  long l = localFile.length();
                  if (l <= 0L) {
                    continue;
                  }
                }
                catch (Exception paramView)
                {
                  File localFile;
                  byte[] arrayOfByte;
                  paramView = localResources.getDrawable(2130844236);
                  continue;
                  boolean bool = false;
                  continue;
                  paramView = localResources.getDrawable(2130844236);
                  continue;
                  paramView = localResources.getDrawable(2130844236);
                  continue;
                }
                try
                {
                  arrayOfByte = FileUtils.b(localFile);
                  paramViewGroup = paramView;
                  if (arrayOfByte != null) {
                    paramViewGroup = Drawable.createFromStream(new ByteArrayInputStream(arrayOfByte), "voiceChangeIcon");
                  }
                }
                catch (Exception paramViewGroup)
                {
                  paramViewGroup.printStackTrace();
                  paramViewGroup = paramView;
                }
              }
              paramView = paramViewGroup;
              if (paramViewGroup == null)
              {
                paramView = URLDrawable.URLDrawableOptions.obtain();
                paramView.mFailedDrawable = localResources.getDrawable(2130844236);
                paramView.mLoadingDrawable = localResources.getDrawable(2130844236);
                paramView = URLDrawable.getDrawable(localFile, paramView);
                if ("drawable not null: " + paramView == null) {
                  break label669;
                }
                bool = true;
                QLog.e("blessVoiceIcon", 1, new Object[] { Boolean.valueOf(bool) });
              }
              paramView.setBounds(0, 0, paramInt, paramInt);
              localTextView.setCompoundDrawables(null, paramView, null, null);
            }
          }
          else
          {
            if (localQQStoryMusicInfo.equals(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo)) {
              localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130843579, 0, 0);
            }
            for (;;)
            {
              localTextView.setTag(localQQStoryMusicInfo);
              break;
              localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130843578, 0, 0);
            }
          }
        }
      }
    }
    localTextView.setTextColor(-1);
    localTextView.getCompoundDrawables()[1].clearColorFilter();
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.music.MusicGridAdapter
 * JD-Core Version:    0.7.0.1
 */