import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.biz.pubaccount.readinjoy.ugc.editvideo.EditVideoFragment;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;

public class rjj
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private qzp jdField_a_of_type_Qzp;
  private qzy jdField_a_of_type_Qzy = new qzy();
  private rjc jdField_a_of_type_Rjc = new rjc();
  private rjf jdField_a_of_type_Rjf;
  private rjs jdField_a_of_type_Rjs = new rjs();
  
  public rjj(Activity paramActivity, rjf paramrjf)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Rjf = paramrjf;
    c();
  }
  
  private void a(Bitmap paramBitmap, String paramString)
  {
    paramBitmap = new rjg(paramBitmap, paramString);
    paramBitmap.a(new rjr(this));
    paramBitmap.a();
  }
  
  private void c()
  {
    this.jdField_a_of_type_Rjc.a("暂不支持该类视频格式", new rjk(this));
    this.jdField_a_of_type_Rjc.a("视频时长短于5秒，无法上传", new rjl(this));
    this.jdField_a_of_type_Rjc.a("视频文件不存在", new rjm(this));
    String str = "视频大小超过" + scm.b() + "，无法上传";
    this.jdField_a_of_type_Rjc.a(str, new rjn(this));
    this.jdField_a_of_type_Qzy.a(new rjo(this));
  }
  
  private void d()
  {
    URL localURL = bhkd.generateAlbumVideoThumbURL(this.jdField_a_of_type_Qzp.b, null);
    this.jdField_a_of_type_Qzp.e = beqz.d(localURL.toString());
    if (new File(this.jdField_a_of_type_Qzp.e).exists())
    {
      f();
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(localURL, null);
    if (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1)
    {
      a(bhmq.b(this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable()), this.jdField_a_of_type_Qzp.e);
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new rjq(this));
    this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
  }
  
  private void e()
  {
    int j = 0;
    int i;
    if (this.jdField_a_of_type_Qzp == null)
    {
      i = 1;
      if (i != 0) {
        i = j;
      }
    }
    for (;;)
    {
      if (i >= this.jdField_a_of_type_Rjf.a()) {
        break label76;
      }
      qzp localqzp = this.jdField_a_of_type_Rjf.a(i);
      if (this.jdField_a_of_type_Rjc.a(localqzp, null))
      {
        this.jdField_a_of_type_Rjf.b(i);
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
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131694016, 1).a();
  }
  
  private void f()
  {
    Intent localIntent = this.jdField_a_of_type_AndroidAppActivity.getIntent();
    EditVideoFragment.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Qzp, 10001, localIntent);
  }
  
  private void g()
  {
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, "请选择一个视频", 0).a();
  }
  
  public rjs a()
  {
    return this.jdField_a_of_type_Rjs;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Qzy.a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Qzy.a(paramInt);
  }
  
  public void a(qzp paramqzp)
  {
    this.jdField_a_of_type_Qzp = paramqzp;
    this.jdField_a_of_type_Rjs.a(paramqzp);
  }
  
  public boolean a(qzp paramqzp)
  {
    return this.jdField_a_of_type_Rjc.a(paramqzp, new rjp(this));
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Qzp == null)
    {
      QLog.e("RIJUGC.SelectVideoPresenter", 1, "saveVideoCoverAndJump failed for selectMediaInfo is null.");
      return;
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rjj
 * JD-Core Version:    0.7.0.1
 */