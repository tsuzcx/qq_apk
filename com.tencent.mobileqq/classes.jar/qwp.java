import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.editvideo.EditVideoFragment;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;

public class qwp
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private qnz jdField_a_of_type_Qnz;
  private qoi jdField_a_of_type_Qoi = new qoi();
  private qwi jdField_a_of_type_Qwi = new qwi();
  private qwl jdField_a_of_type_Qwl;
  private qwy jdField_a_of_type_Qwy = new qwy();
  
  public qwp(Activity paramActivity, qwl paramqwl)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Qwl = paramqwl;
    c();
  }
  
  private void a(Bitmap paramBitmap, String paramString)
  {
    paramBitmap = new qwm(paramBitmap, paramString);
    paramBitmap.a(new qwx(this));
    paramBitmap.a();
  }
  
  private void c()
  {
    this.jdField_a_of_type_Qwi.a("暂不支持该类视频格式", new qwq(this));
    this.jdField_a_of_type_Qwi.a("视频时长短于5秒，无法上传", new qwr(this));
    this.jdField_a_of_type_Qwi.a("视频文件不存在", new qws(this));
    String str = "视频大小超过" + ror.b() + "，无法上传";
    this.jdField_a_of_type_Qwi.a(str, new qwt(this));
    this.jdField_a_of_type_Qoi.a(new qwu(this));
  }
  
  private void d()
  {
    URL localURL = bdar.generateAlbumVideoThumbURL(this.jdField_a_of_type_Qnz.b, null);
    this.jdField_a_of_type_Qnz.e = bame.d(localURL.toString());
    if (new File(this.jdField_a_of_type_Qnz.e).exists())
    {
      f();
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(localURL, null);
    if (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1)
    {
      a(bdda.b(this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable()), this.jdField_a_of_type_Qnz.e);
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new qww(this));
    this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
  }
  
  private void e()
  {
    int j = 0;
    int i;
    if (this.jdField_a_of_type_Qnz == null)
    {
      i = 1;
      if (i != 0) {
        i = j;
      }
    }
    for (;;)
    {
      if (i >= this.jdField_a_of_type_Qwl.a()) {
        break label76;
      }
      qnz localqnz = this.jdField_a_of_type_Qwl.a(i);
      if (this.jdField_a_of_type_Qwi.a(localqnz, null))
      {
        this.jdField_a_of_type_Qwl.b(i);
        return;
        i = 0;
        break;
      }
      i += 1;
    }
    label76:
    if (QLog.isColorLevel()) {
      QLog.d("RIJUGC.SelectVideoPresenter", 2, "not found the select video...");
    }
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131694842, 1).a();
  }
  
  private void f()
  {
    int i = 0;
    ColumnInfo localColumnInfo = null;
    Intent localIntent = this.jdField_a_of_type_AndroidAppActivity.getIntent();
    if (localIntent != null)
    {
      i = localIntent.getIntExtra("key_from", 0);
      localColumnInfo = (ColumnInfo)localIntent.getParcelableExtra("key_column_info");
    }
    EditVideoFragment.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Qnz, localColumnInfo, i, 10001);
  }
  
  private void g()
  {
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, "请选择一个视频", 0).a();
  }
  
  public qwy a()
  {
    return this.jdField_a_of_type_Qwy;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Qoi.a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Qoi.a(paramInt);
  }
  
  public void a(qnz paramqnz)
  {
    this.jdField_a_of_type_Qnz = paramqnz;
    this.jdField_a_of_type_Qwy.a(paramqnz);
  }
  
  public boolean a(qnz paramqnz)
  {
    return this.jdField_a_of_type_Qwi.a(paramqnz, new qwv(this));
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Qnz == null)
    {
      QLog.e("RIJUGC.SelectVideoPresenter", 1, "saveVideoCoverAndJump failed for selectMediaInfo is null.");
      return;
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qwp
 * JD-Core Version:    0.7.0.1
 */