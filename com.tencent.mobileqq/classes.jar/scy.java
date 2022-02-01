import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.biz.pubaccount.readinjoy.ugc.editvideo.EditVideoFragment;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;

public class scy
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private rsv jdField_a_of_type_Rsv;
  private rte jdField_a_of_type_Rte = new rte();
  private scr jdField_a_of_type_Scr = new scr();
  private scu jdField_a_of_type_Scu;
  private sdh jdField_a_of_type_Sdh = new sdh();
  
  public scy(Activity paramActivity, scu paramscu)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Scu = paramscu;
    c();
  }
  
  private void a(Bitmap paramBitmap, String paramString)
  {
    paramBitmap = new scv(paramBitmap, paramString);
    paramBitmap.a(new sdg(this));
    paramBitmap.a();
  }
  
  private void c()
  {
    this.jdField_a_of_type_Scr.a("暂不支持该类视频格式", new scz(this));
    this.jdField_a_of_type_Scr.a("视频时长短于5秒，无法上传", new sda(this));
    this.jdField_a_of_type_Scr.a("视频文件不存在", new sdb(this));
    String str = "视频大小超过" + swb.b() + "，无法上传";
    this.jdField_a_of_type_Scr.a(str, new sdc(this));
    this.jdField_a_of_type_Rte.a(new sdd(this));
  }
  
  private void d()
  {
    URL localURL = AlbumUtil.generateAlbumVideoThumbURL(this.jdField_a_of_type_Rsv.b, null);
    this.jdField_a_of_type_Rsv.e = AbsDownloader.getFilePath(localURL.toString());
    if (new File(this.jdField_a_of_type_Rsv.e).exists())
    {
      f();
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(localURL, null);
    if (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1)
    {
      a(bheg.b(this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable()), this.jdField_a_of_type_Rsv.e);
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new sdf(this));
    this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
  }
  
  private void e()
  {
    int j = 0;
    int i;
    if (this.jdField_a_of_type_Rsv == null)
    {
      i = 1;
      if (i != 0) {
        i = j;
      }
    }
    for (;;)
    {
      if (i >= this.jdField_a_of_type_Scu.a()) {
        break label76;
      }
      rsv localrsv = this.jdField_a_of_type_Scu.a(i);
      if (this.jdField_a_of_type_Scr.a(localrsv, null))
      {
        this.jdField_a_of_type_Scu.b(i);
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
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131694313, 1).a();
  }
  
  private void f()
  {
    Intent localIntent = this.jdField_a_of_type_AndroidAppActivity.getIntent();
    EditVideoFragment.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Rsv, 10001, localIntent);
  }
  
  private void g()
  {
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, "请选择一个视频", 0).a();
  }
  
  public sdh a()
  {
    return this.jdField_a_of_type_Sdh;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Rte.a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Rte.a(paramInt);
  }
  
  public void a(rsv paramrsv)
  {
    this.jdField_a_of_type_Rsv = paramrsv;
    this.jdField_a_of_type_Sdh.a(paramrsv);
  }
  
  public boolean a(rsv paramrsv)
  {
    return this.jdField_a_of_type_Scr.a(paramrsv, new sde(this));
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Rsv == null)
    {
      QLog.e("RIJUGC.SelectVideoPresenter", 1, "saveVideoCoverAndJump failed for selectMediaInfo is null.");
      return;
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     scy
 * JD-Core Version:    0.7.0.1
 */