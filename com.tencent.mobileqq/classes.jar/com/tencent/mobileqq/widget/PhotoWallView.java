package com.tencent.mobileqq.widget;

import NS_MOBILE_MAIN_PAGE.PhotoWall;
import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
import ajti;
import ajtn;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import axqy;
import bcny;
import bcop;
import bcoq;
import bcor;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ProfilePhotoWall;
import com.tencent.mobileqq.data.QZonePhotoInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PhotoWallView
  extends FrameLayout
  implements Handler.Callback, View.OnClickListener, bcny
{
  protected int a;
  protected ajti a;
  private ajtn a;
  protected Activity a;
  public Handler a;
  protected LayoutInflater a;
  protected View a;
  public Button a;
  protected ImageView a;
  protected TextView a;
  protected bcoq a;
  protected bcor a;
  protected QQAppInterface a;
  protected ProfileCardNewPhotoWallView a;
  public String a;
  public ArrayList<ProfilePhotoWall> a;
  protected LinkedList<ProfilePhotoWall> a;
  protected View b;
  protected ImageView b;
  public TextView b;
  protected View c;
  protected ImageView c;
  public TextView c;
  protected View d;
  protected View e;
  
  public PhotoWallView(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, bcoq parambcoq)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Ajtn = new bcop(this);
    this.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Bcoq = parambcoq;
    c();
  }
  
  public static List<ProfilePhotoWall> a(List<ProfilePhotoWall> paramList1, List<ProfilePhotoWall> paramList2)
  {
    if (paramList2.size() == 0) {
      return paramList1;
    }
    if (paramList1.size() == 0)
    {
      paramList1.addAll(paramList2);
      return paramList1;
    }
    int j = 0;
    int i = 0;
    label34:
    if (j < paramList2.size())
    {
      ProfilePhotoWall localProfilePhotoWall1 = (ProfilePhotoWall)paramList2.get(j);
      label56:
      if (i >= paramList1.size()) {
        break label123;
      }
      ProfilePhotoWall localProfilePhotoWall2 = (ProfilePhotoWall)paramList1.get(i);
      if (localProfilePhotoWall1.time >= localProfilePhotoWall2.time) {
        break label116;
      }
      int k = i + 1;
      paramList1.add(i, localProfilePhotoWall1);
      i = k;
    }
    label116:
    label123:
    for (;;)
    {
      j += 1;
      break label34;
      break;
      i += 1;
      break label56;
    }
  }
  
  private void a(Message paramMessage)
  {
    paramMessage = (ArrayList)paramMessage.obj;
    if (paramMessage != null)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.clear();
      this.jdField_a_of_type_JavaUtilLinkedList.addAll(paramMessage);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() != 0) {
        a(this.jdField_a_of_type_JavaUtilLinkedList, this.jdField_a_of_type_JavaUtilArrayList);
      }
      if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 9)
      {
        int i = this.jdField_a_of_type_JavaUtilLinkedList.size() - 1;
        while (i >= 9)
        {
          this.jdField_a_of_type_JavaUtilLinkedList.remove(i);
          i -= 1;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardNewPhotoWallView.a(this.jdField_a_of_type_JavaUtilLinkedList, this.jdField_a_of_type_JavaUtilLinkedList.size());
    }
  }
  
  private void a(boolean paramBoolean)
  {
    String str = "http://ti.qq.com/photowall/index.html?_wv=1027";
    if (!paramBoolean) {
      str = "http://ti.qq.com/photowall/index.html?_wv=1027" + "&uin=" + this.jdField_a_of_type_JavaLangString;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("url", str);
    if (!paramBoolean)
    {
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      return;
    }
    this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(localIntent, 1022);
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(getContext());
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_Ajti = ((ajti)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2));
    this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(a(), this, true);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131371573);
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardNewPhotoWallView = ((ProfileCardNewPhotoWallView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371582));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131371585);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131371586);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371587));
    this.d = findViewById(2131371574);
    this.e = findViewById(2131371575);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371576));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371577));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371578));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371580));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371579));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.d.findViewById(2131371581));
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardNewPhotoWallView.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.e.setAlpha(0.15F);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695439);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      ThreadManager.post(new PhotoWallView.1(this), 5, null, true);
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695438);
    }
  }
  
  private void d()
  {
    boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(this.jdField_a_of_type_JavaLangString);
    boolean bool2 = this.jdField_a_of_type_JavaUtilLinkedList.isEmpty();
    if (bool1)
    {
      if (bool2)
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.d.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.d.setVisibility(8);
      return;
    }
    this.d.setVisibility(8);
    if (bool2)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  protected int a()
  {
    return 2131560998;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Bcor.c == 1) && (this.jdField_a_of_type_Bcor.jdField_a_of_type_Int < 9))
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_Ajti.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bcor.jdField_a_of_type_JavaLangString);
    }
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString, ArrayList<PhotoWall> paramArrayList, List<ProfilePhotoWall> paramList)
  {
    if (this.jdField_a_of_type_Bcor == null) {
      this.jdField_a_of_type_Bcor = new bcor();
    }
    this.jdField_a_of_type_Bcor.b = paramInt1;
    this.jdField_a_of_type_Bcor.c = paramInt2;
    this.jdField_a_of_type_Bcor.jdField_a_of_type_JavaLangString = paramString;
    if (paramArrayList != null)
    {
      paramString = paramArrayList.iterator();
      while (paramString.hasNext())
      {
        paramArrayList = (PhotoWall)paramString.next();
        QZonePhotoInfo localQZonePhotoInfo = new QZonePhotoInfo();
        localQZonePhotoInfo.uin = this.jdField_a_of_type_JavaLangString;
        localQZonePhotoInfo.time = paramArrayList.ctime;
        localQZonePhotoInfo.photoId = paramArrayList.photoId;
        localQZonePhotoInfo.photoUrls = paramArrayList.photoUrls;
        paramList.add(localQZonePhotoInfo);
      }
      this.jdField_a_of_type_Bcor.jdField_a_of_type_Int = paramList.size();
    }
  }
  
  public void a(boolean paramBoolean, String paramString, mobile_sub_get_photo_wall_rsp parammobile_sub_get_photo_wall_rsp)
  {
    if (!paramBoolean) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
    }
    while (parammobile_sub_get_photo_wall_rsp == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(paramString)) {
      localArrayList.addAll(this.jdField_a_of_type_JavaUtilLinkedList);
    }
    a(parammobile_sub_get_photo_wall_rsp.total_pic, parammobile_sub_get_photo_wall_rsp.iHasMore, parammobile_sub_get_photo_wall_rsp.attachInfo, parammobile_sub_get_photo_wall_rsp.vecUrls, localArrayList);
    paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
    paramString.obj = localArrayList;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Bcor != null) {
      return this.jdField_a_of_type_Bcor.c == 1;
    }
    return false;
  }
  
  public void b()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(this.jdField_a_of_type_JavaLangString));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 3: 
    case 1: 
    case 2: 
    case 4: 
      do
      {
        do
        {
          return true;
          if (QLog.isColorLevel()) {
            QLog.d("PhotoWallView", 2, "handleMessage MSG_LOAD_PHOTO_WALL");
          }
          this.jdField_a_of_type_Int = 0;
          this.jdField_a_of_type_Ajti.a(this.jdField_a_of_type_JavaLangString, "");
          try
          {
            long l = Long.parseLong(this.jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_Ajti.a(l, this.jdField_a_of_type_Ajtn);
            this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
            return true;
          }
          catch (Exception paramMessage)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.e("PhotoWallView", 2, "handleMessage MSG_LOAD_PHOTO_WALL fail!", paramMessage);
              }
              this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("PhotoWallView", 2, "handleMessage MSG_LOAD_FROM_DATABASE");
          }
          a(paramMessage);
          if ((this.jdField_a_of_type_Bcoq != null) && (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)) {
            this.jdField_a_of_type_Bcoq.b(this.jdField_a_of_type_JavaUtilLinkedList.size());
          }
          d();
          paramMessage = Message.obtain();
          paramMessage.what = 3;
          handleMessage(paramMessage);
          return true;
          if (QLog.isColorLevel()) {
            QLog.d("PhotoWallView", 2, "handleMessage MSG_LOAD_FROM_SERVER");
          }
          this.jdField_a_of_type_Int |= 0x1;
          a(paramMessage);
          if ((this.jdField_a_of_type_Bcoq != null) && (this.jdField_a_of_type_Int == 17))
          {
            this.jdField_a_of_type_Bcoq.b(this.jdField_a_of_type_JavaUtilLinkedList.size());
            d();
          }
        } while (this.jdField_a_of_type_Bcor.c == 1);
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        return true;
        if (QLog.isColorLevel()) {
          QLog.d("PhotoWallView", 2, "handleMessage MSG_ADD_NOW_VIDEO_GALLERY");
        }
        this.jdField_a_of_type_Int |= 0x10;
        a(this.jdField_a_of_type_JavaUtilLinkedList, this.jdField_a_of_type_JavaUtilArrayList);
        this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardNewPhotoWallView.a(this.jdField_a_of_type_JavaUtilLinkedList, this.jdField_a_of_type_JavaUtilLinkedList.size());
      } while ((this.jdField_a_of_type_Bcoq == null) || (this.jdField_a_of_type_Int != 17));
      this.jdField_a_of_type_Bcoq.b(this.jdField_a_of_type_JavaUtilLinkedList.size());
      d();
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhotoWallView", 2, "handleMessage MSG_LOAD_PHOTO_WALL_FAILED");
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    return true;
  }
  
  public void onClick(View paramView)
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(this.jdField_a_of_type_JavaLangString);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131371587: 
      b();
      if (bool)
      {
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007EBE", "0X8007EBE", 0, 0, "", "", "", "");
        return;
      }
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007EBF", "0X8007EBF", 0, 0, "", "", "", "");
      return;
    }
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007EC0", "0X8007EC0", 0, 0, "", "", "", "");
    a(bool);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    float f = localDisplayMetrics.density;
    paramInt2 = Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels) - getResources().getDimensionPixelSize(2131297369) * 2;
    paramInt1 = (int)(f * 2.0F + 0.5F);
    paramInt3 = (paramInt2 - paramInt1) * 2 / 3;
    this.jdField_a_of_type_AndroidWidgetImageView.layout(0, 0, 0 + paramInt3, paramInt3 + 0 + paramInt1);
    paramInt3 = (paramInt2 - paramInt1) / 3;
    paramInt4 = paramInt2 - paramInt3;
    this.jdField_b_of_type_AndroidWidgetImageView.layout(paramInt4, 0, paramInt4 + paramInt3, paramInt3 + 0);
    paramInt3 = (paramInt2 - paramInt1) / 3;
    paramInt2 -= paramInt3;
    paramInt1 += paramInt3;
    this.jdField_c_of_type_AndroidWidgetImageView.layout(paramInt2, paramInt1, paramInt2 + paramInt3, paramInt3 + paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PhotoWallView
 * JD-Core Version:    0.7.0.1
 */