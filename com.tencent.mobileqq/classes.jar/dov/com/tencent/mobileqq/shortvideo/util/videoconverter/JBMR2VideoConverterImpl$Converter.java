package dov.com.tencent.mobileqq.shortvideo.util.videoconverter;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.media.MediaMuxer;
import android.view.Surface;
import bjkf;
import bjmc;
import bjmd;
import bjmh;
import bjmi;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import leg;

class JBMR2VideoConverterImpl$Converter
  implements Runnable
{
  long jdField_a_of_type_Long = -1L;
  MediaExtractor jdField_a_of_type_AndroidMediaMediaExtractor = null;
  MediaMuxer jdField_a_of_type_AndroidMediaMediaMuxer = null;
  bjkf jdField_a_of_type_Bjkf = null;
  bjmc jdField_a_of_type_Bjmc = null;
  bjmd jdField_a_of_type_Bjmd = null;
  bjmh jdField_a_of_type_Bjmh = null;
  File jdField_a_of_type_JavaIoFile = null;
  boolean jdField_a_of_type_Boolean = true;
  long jdField_b_of_type_Long = -1L;
  MediaExtractor jdField_b_of_type_AndroidMediaMediaExtractor = null;
  bjkf jdField_b_of_type_Bjkf = null;
  boolean jdField_b_of_type_Boolean = true;
  long jdField_c_of_type_Long = -1L;
  boolean jdField_c_of_type_Boolean = false;
  boolean d;
  
  public JBMR2VideoConverterImpl$Converter(JBMR2VideoConverterImpl paramJBMR2VideoConverterImpl, File paramFile, bjmh parambjmh)
  {
    this.jdField_a_of_type_JavaIoFile = paramFile;
    this.jdField_a_of_type_Bjmh = parambjmh;
  }
  
  int a(MediaExtractor paramMediaExtractor)
  {
    int i = 0;
    try
    {
      while (i < paramMediaExtractor.getTrackCount())
      {
        if (QLog.isColorLevel()) {
          QLog.d("JBMR2VideoConverterImpl", 2, "format for track " + i + " is " + paramMediaExtractor.getTrackFormat(i).getString("mime"));
        }
        if (paramMediaExtractor.getTrackFormat(i).getString("mime").startsWith("video/"))
        {
          paramMediaExtractor.selectTrack(i);
          return i;
        }
        i += 1;
      }
      return -1;
    }
    catch (Exception paramMediaExtractor) {}
  }
  
  MediaCodecInfo a(String paramString)
  {
    int k = MediaCodecList.getCodecCount();
    int i = 0;
    if (i < k)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (!localMediaCodecInfo.isEncoder()) {}
      for (;;)
      {
        i += 1;
        break;
        String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
        int j = 0;
        while (j < arrayOfString.length)
        {
          if (arrayOfString[j].equalsIgnoreCase(paramString)) {
            return localMediaCodecInfo;
          }
          j += 1;
        }
      }
    }
    return null;
  }
  
  bjkf a(MediaFormat paramMediaFormat, Surface paramSurface)
  {
    Object localObject = bjkf.a(paramMediaFormat.getString("mime"), false);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = (MediaCodecInfo)((List)localObject).get(0);
      bjkf localbjkf = new bjkf();
      localbjkf.a(paramMediaFormat, ((MediaCodecInfo)localObject).getName(), paramSurface, null);
      localbjkf.a();
      return localbjkf;
    }
    return null;
  }
  
  bjkf a(MediaFormat paramMediaFormat, AtomicReference<Surface> paramAtomicReference)
  {
    bjkf localbjkf = new bjkf();
    localbjkf.a(paramMediaFormat, bjkf.jdField_a_of_type_Int, null);
    paramAtomicReference.set(localbjkf.a().createInputSurface());
    localbjkf.a();
    return localbjkf;
  }
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("JBMR2VideoConverterImpl", 2, "shutting down encoder, decoder");
    }
    if (this.jdField_a_of_type_Bjmd != null) {
      this.jdField_a_of_type_Bjmd.b();
    }
    if (this.jdField_a_of_type_Bjmc != null) {
      this.jdField_a_of_type_Bjmc.b();
    }
    if (this.jdField_b_of_type_Bjkf != null)
    {
      this.jdField_b_of_type_Bjkf.c();
      this.jdField_b_of_type_Bjkf.d();
    }
    if (this.jdField_a_of_type_Bjkf != null)
    {
      this.jdField_a_of_type_Bjkf.c();
      this.jdField_a_of_type_Bjkf.d();
    }
    if (this.jdField_a_of_type_AndroidMediaMediaMuxer != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaMuxer.release();
      this.jdField_a_of_type_AndroidMediaMediaMuxer = null;
    }
    if (this.jdField_a_of_type_AndroidMediaMediaExtractor != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaExtractor.release();
      this.jdField_a_of_type_AndroidMediaMediaExtractor = null;
    }
    if (this.jdField_b_of_type_AndroidMediaMediaExtractor != null)
    {
      this.jdField_b_of_type_AndroidMediaMediaExtractor.release();
      this.jdField_b_of_type_AndroidMediaMediaExtractor = null;
    }
  }
  
  void a(MediaExtractor paramMediaExtractor1, MediaExtractor paramMediaExtractor2, bjkf parambjkf1, bjkf parambjkf2, MediaMuxer paramMediaMuxer, bjmc parambjmc, bjmd parambjmd)
  {
    int i2 = 0;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(262144);
    int i = 0;
    int j = 0;
    MediaFormat localMediaFormat1 = null;
    int i1 = -1;
    int k = 0;
    int m = -1;
    long l1 = 0L;
    long l2 = 0L;
    int n = 0;
    MediaFormat localMediaFormat2 = null;
    long l3 = -1L;
    if (((this.jdField_b_of_type_Boolean) && (i == 0)) || ((this.jdField_a_of_type_Boolean) && (k == 0)))
    {
      this.jdField_d_of_type_Boolean = Thread.interrupted();
      if (!this.jdField_d_of_type_Boolean) {}
    }
    else
    {
      return;
    }
    Object localObject;
    label153:
    int i4;
    label186:
    label233:
    long l5;
    if ((this.jdField_a_of_type_Boolean) && (k == 0) && ((localMediaFormat2 == null) || (i2 != 0))) {
      if ((localMediaFormat2 != null) && (i2 != 0))
      {
        localObject = new MediaCodec.BufferInfo();
        ((MediaCodec.BufferInfo)localObject).size = paramMediaExtractor2.readSampleData(localByteBuffer, 0);
        if (((MediaCodec.BufferInfo)localObject).size < 0)
        {
          k = 1;
          if (k != 0) {}
          if ((l2 < l1) && (l1 - l2 > 0L) && (k == 0) && (this.jdField_a_of_type_Boolean)) {
            break label553;
          }
          i4 = 1;
          if ((!this.jdField_b_of_type_Boolean) || (n != 0) || ((localMediaFormat1 != null) && (i2 == 0)) || (i4 == 0)) {
            break label1121;
          }
          localObject = parambjkf1.a();
          if (localObject == null) {
            break label1121;
          }
          if (((leg)localObject).jdField_a_of_type_Int != -1) {
            break label559;
          }
          l5 = l3;
          if (!this.jdField_b_of_type_Boolean) {
            break label1108;
          }
          l5 = l3;
          if (j != 0) {
            break label1108;
          }
          if (localMediaFormat1 != null)
          {
            l5 = l3;
            if (i2 == 0) {
              break label1108;
            }
          }
          l5 = l3;
          if (i4 == 0) {
            break label1108;
          }
          localObject = parambjkf1.b();
          if (localObject != null) {
            break label698;
          }
          label287:
          if ((!this.jdField_b_of_type_Boolean) || (i != 0) || ((localMediaFormat1 != null) && (i2 == 0)) || (i4 == 0)) {
            break label1105;
          }
          localObject = parambjkf2.b();
          if (localObject != null) {
            break label925;
          }
          label326:
          if ((i2 != 0) || ((this.jdField_a_of_type_Boolean) && (localMediaFormat2 == null)) || ((this.jdField_b_of_type_Boolean) && (localMediaFormat1 == null))) {
            break label1130;
          }
          if (this.jdField_b_of_type_Boolean)
          {
            if (QLog.isColorLevel()) {
              QLog.d("JBMR2VideoConverterImpl", 2, "muxer: adding video track.");
            }
            m = paramMediaMuxer.addTrack(localMediaFormat1);
          }
          if (!this.jdField_a_of_type_Boolean) {
            break label1127;
          }
          if (QLog.isColorLevel()) {
            QLog.d("JBMR2VideoConverterImpl", 2, "muxer: adding audio track.");
          }
          i1 = paramMediaMuxer.addTrack(localMediaFormat2);
          label415:
          if (QLog.isColorLevel()) {
            QLog.d("JBMR2VideoConverterImpl", 2, "muxer: starting");
          }
          paramMediaMuxer.start();
          i2 = 1;
        }
      }
    }
    label553:
    label559:
    label599:
    label1121:
    label1127:
    label1130:
    for (;;)
    {
      break;
      ((MediaCodec.BufferInfo)localObject).presentationTimeUs = paramMediaExtractor2.getSampleTime();
      ((MediaCodec.BufferInfo)localObject).flags = paramMediaExtractor2.getSampleFlags();
      paramMediaMuxer.writeSampleData(i1, localByteBuffer, (MediaCodec.BufferInfo)localObject);
      if (!paramMediaExtractor2.advance()) {}
      for (int i3 = 1;; i3 = 0)
      {
        l4 = ((MediaCodec.BufferInfo)localObject).presentationTimeUs;
        k = i3;
        l2 = l4;
        if (this.jdField_c_of_type_Long <= 0L) {
          break;
        }
        k = i3;
        l2 = l4;
        if (((MediaCodec.BufferInfo)localObject).presentationTimeUs < this.jdField_c_of_type_Long) {
          break;
        }
        k = 1;
        l2 = l4;
        break;
      }
      localMediaFormat2 = paramMediaExtractor2.getTrackFormat(paramMediaExtractor2.getSampleTrackIndex());
      break label153;
      i4 = 0;
      break label186;
      int i5 = paramMediaExtractor1.readSampleData(((leg)localObject).jdField_a_of_type_JavaNioByteBuffer, 0);
      long l4 = paramMediaExtractor1.getSampleTime();
      if (this.jdField_c_of_type_Long > 0L) {
        if (l4 >= this.jdField_c_of_type_Long) {
          n = 1;
        }
      }
      for (;;)
      {
        if (i5 >= 0)
        {
          int i6 = ((leg)localObject).jdField_a_of_type_Int;
          if (n != 0)
          {
            i3 = 4;
            label619:
            parambjkf1.a(i6, i5, l4, i3);
          }
        }
        else
        {
          if (paramMediaExtractor1.advance()) {
            break label692;
          }
        }
        for (i3 = 1;; i3 = 0)
        {
          if (n != 0) {
            i3 = 1;
          }
          n = i3;
          if (i3 == 0) {
            break;
          }
          parambjkf1.a(((leg)localObject).jdField_a_of_type_Int, 0, 0L, 4);
          n = i3;
          break;
          n = 0;
          break label599;
          i3 = paramMediaExtractor1.getSampleFlags();
          break label619;
        }
        MediaCodec.BufferInfo localBufferInfo = ((leg)localObject).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo;
        i5 = ((leg)localObject).jdField_a_of_type_Int;
        if ((i5 == -1) || (i5 == -3)) {
          break label287;
        }
        if (i5 == -2)
        {
          parambjkf1.a().getOutputFormat();
          break label287;
        }
        if ((localBufferInfo.flags & 0x2) != 0)
        {
          parambjkf1.a(((leg)localObject).jdField_a_of_type_Int);
          break label287;
        }
        i3 = 0;
        if (this.jdField_c_of_type_Boolean)
        {
          if (localBufferInfo.presentationTimeUs < this.jdField_b_of_type_Long) {
            i3 = 1;
          }
        }
        else {
          if ((localBufferInfo.size == 0) || (i3 != 0)) {
            break label919;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          parambjkf1.a().releaseOutputBuffer(i5, bool);
          l4 = l3;
          if (bool)
          {
            parambjmd.c();
            parambjmd.d();
            parambjmc.a(localBufferInfo.presentationTimeUs * 1000L);
            parambjmc.a();
            l4 = l3;
            if (l3 < 0L) {
              l4 = localBufferInfo.presentationTimeUs;
            }
          }
          l5 = l4;
          if ((localBufferInfo.flags & 0x4) == 0) {
            break label1108;
          }
          parambjkf2.a().signalEndOfInputStream();
          j = 1;
          l3 = l4;
          break;
          i3 = 0;
          break label797;
        }
        localBufferInfo = ((leg)localObject).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo;
        i3 = ((leg)localObject).jdField_a_of_type_Int;
        if ((i3 == -1) || (i3 == -3)) {
          break label326;
        }
        if (i3 == -2)
        {
          if (m >= 0) {
            throw new IOException("video encoder changed its output format again?");
          }
          localMediaFormat1 = parambjkf2.a().getOutputFormat();
          break label326;
        }
        if ((localBufferInfo.flags & 0x2) != 0)
        {
          parambjkf2.a(((leg)localObject).jdField_a_of_type_Int);
          break label326;
        }
        if (localBufferInfo.size != 0)
        {
          paramMediaMuxer.writeSampleData(m, ((leg)localObject).jdField_a_of_type_JavaNioByteBuffer, localBufferInfo);
          l1 = localBufferInfo.presentationTimeUs;
          float f = (float)(localBufferInfo.presentationTimeUs - l3) / (float)this.jdField_a_of_type_Long;
          this.jdField_a_of_type_Bjmh.a((int)(f * 10000.0F));
        }
        if ((localBufferInfo.flags & 0x4) != 0) {
          i = 1;
        }
        parambjkf2.a(((leg)localObject).jdField_a_of_type_Int);
        break label326;
        break label326;
        l3 = l5;
        break label287;
        n = 0;
      }
      break label233;
      break label153;
      break label415;
    }
  }
  
  protected void a(File paramFile, bjmh parambjmh)
  {
    Object localObject1 = paramFile.getAbsolutePath();
    Object localObject2 = a("video/avc");
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("JBMR2VideoConverterImpl", 2, "Unable to find an appropriate codec for video/avc");
      }
      throw new IOException("Unable to find an appropriate codec for video/avc");
    }
    if (QLog.isColorLevel()) {
      QLog.d("JBMR2VideoConverterImpl", 2, "video found codec: " + ((MediaCodecInfo)localObject2).getName());
    }
    MediaExtractor localMediaExtractor1 = new MediaExtractor();
    MediaExtractor localMediaExtractor2 = new MediaExtractor();
    try
    {
      localMediaExtractor1.setDataSource((String)localObject1);
      localMediaExtractor2.setDataSource((String)localObject1);
      if (b(localMediaExtractor1) < 0) {
        this.jdField_a_of_type_Boolean = false;
      }
      i = a(localMediaExtractor2);
      if (i < 0)
      {
        localMediaExtractor2.release();
        localMediaExtractor1.release();
        throw new IOException("No video track found in " + paramFile);
      }
    }
    catch (IOException paramFile)
    {
      paramFile.printStackTrace();
      localMediaExtractor2.release();
      localMediaExtractor1.release();
      return;
    }
    Object localObject3 = localMediaExtractor2.getTrackFormat(i);
    paramFile = a((MediaFormat)localObject3, (String)localObject1);
    int n = (int)paramFile[2];
    int j = (int)paramFile[0];
    int i = (int)paramFile[1];
    this.jdField_a_of_type_Long = paramFile[3];
    bjmi localbjmi = parambjmh.a(j, i);
    if ((localbjmi.jdField_a_of_type_Long >= 0L) && (localbjmi.jdField_b_of_type_Long > 0L) && (localbjmi.jdField_b_of_type_Long - localbjmi.jdField_a_of_type_Long >= 1000L))
    {
      this.jdField_c_of_type_Long = (localbjmi.jdField_b_of_type_Long * 1000L);
      this.jdField_b_of_type_Long = (localbjmi.jdField_a_of_type_Long * 1000L);
      this.jdField_a_of_type_Long = (this.jdField_c_of_type_Long - this.jdField_b_of_type_Long);
      localMediaExtractor2.seekTo(this.jdField_b_of_type_Long, 2);
      localMediaExtractor1.seekTo(this.jdField_b_of_type_Long, 2);
    }
    if (localbjmi.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_Boolean = false;
    }
    if (localbjmi.jdField_d_of_type_Boolean) {
      this.jdField_c_of_type_Boolean = true;
    }
    int k;
    int m;
    if ((!localbjmi.jdField_b_of_type_Boolean) && ((n == 90) || (n == 270)))
    {
      localObject1 = null;
      parambjmh = null;
      paramFile = null;
      if (!this.jdField_b_of_type_Boolean) {
        break label817;
      }
      if ((localbjmi.h > 0) && (localbjmi.i > 0)) {
        break label780;
      }
      k = Math.round(i * localbjmi.jdField_a_of_type_Float / 16.0F) * 16;
      m = Math.round(j * localbjmi.jdField_a_of_type_Float / 16.0F) * 16;
      label462:
      parambjmh = MediaFormat.createVideoFormat("video/avc", k, m);
      parambjmh.setInteger("color-format", 2130708361);
      parambjmh.setInteger("bitrate", localbjmi.jdField_a_of_type_Int);
      parambjmh.setFloat("frame-rate", localbjmi.jdField_b_of_type_Int);
      parambjmh.setInteger("i-frame-interval", localbjmi.jdField_c_of_type_Int);
      if (localbjmi.jdField_a_of_type_Boolean)
      {
        parambjmh.setInteger("profile", localbjmi.jdField_d_of_type_Int);
        parambjmh.setInteger("level", localbjmi.e);
      }
      if (QLog.isColorLevel()) {
        QLog.d("JBMR2VideoConverterImpl", 2, "video format: " + parambjmh);
      }
      paramFile = new AtomicReference();
      localObject2 = a(parambjmh, paramFile);
      parambjmh = new bjmc((Surface)paramFile.get());
      parambjmh.c();
      paramFile = new bjmd();
      if ((localbjmi.h > 0) && (localbjmi.i > 0)) {
        paramFile.a(k, m, i, j, localbjmi.f, localbjmi.g, localbjmi.h, localbjmi.i);
      }
      localObject1 = a((MediaFormat)localObject3, paramFile.a);
    }
    for (;;)
    {
      localObject3 = new MediaMuxer(localbjmi.jdField_a_of_type_JavaIoFile.getAbsolutePath(), 0);
      if ((this.jdField_b_of_type_Boolean) && (localbjmi.jdField_b_of_type_Boolean)) {
        ((MediaMuxer)localObject3).setOrientationHint(n);
      }
      this.jdField_a_of_type_AndroidMediaMediaExtractor = localMediaExtractor2;
      this.jdField_b_of_type_AndroidMediaMediaExtractor = localMediaExtractor1;
      this.jdField_a_of_type_Bjkf = ((bjkf)localObject1);
      this.jdField_b_of_type_Bjkf = ((bjkf)localObject2);
      this.jdField_a_of_type_AndroidMediaMediaMuxer = ((MediaMuxer)localObject3);
      this.jdField_a_of_type_Bjmc = parambjmh;
      this.jdField_a_of_type_Bjmd = paramFile;
      return;
      k = i;
      i = j;
      j = k;
      break;
      label780:
      k = Math.round(localbjmi.h / 16) * 16;
      m = Math.round(localbjmi.i / 16) * 16;
      break label462;
      label817:
      localObject2 = null;
    }
  }
  
  long[] a(MediaFormat paramMediaFormat, String paramString)
  {
    int j = paramMediaFormat.getInteger("width");
    int k = paramMediaFormat.getInteger("height");
    long l = paramMediaFormat.getLong("durationUs");
    paramMediaFormat = new MediaMetadataRetriever();
    paramMediaFormat.setDataSource(paramString);
    paramString = paramMediaFormat.extractMetadata(24);
    int i;
    if (paramString == null) {
      i = 0;
    }
    for (;;)
    {
      paramMediaFormat.release();
      if (QLog.isColorLevel()) {
        QLog.d("JBMR2VideoConverterImpl", 2, "Video size is " + j + "x" + k + ". rotation: " + paramString);
      }
      return new long[] { j, k, i, l };
      try
      {
        i = Integer.parseInt(paramString);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        i = 0;
      }
    }
  }
  
  int b(MediaExtractor paramMediaExtractor)
  {
    int i = 0;
    try
    {
      while (i < paramMediaExtractor.getTrackCount())
      {
        if (QLog.isColorLevel()) {
          QLog.d("JBMR2VideoConverterImpl", 2, "format for track " + i + " is " + paramMediaExtractor.getTrackFormat(i).getString("mime"));
        }
        if (paramMediaExtractor.getTrackFormat(i).getString("mime").startsWith("audio/"))
        {
          paramMediaExtractor.selectTrack(i);
          return i;
        }
        i += 1;
      }
      return -1;
    }
    catch (Exception paramMediaExtractor) {}
  }
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_Bjmh.a(0);
      a(this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_Bjmh);
      a(this.jdField_a_of_type_AndroidMediaMediaExtractor, this.jdField_b_of_type_AndroidMediaMediaExtractor, this.jdField_a_of_type_Bjkf, this.jdField_b_of_type_Bjkf, this.jdField_a_of_type_AndroidMediaMediaMuxer, this.jdField_a_of_type_Bjmc, this.jdField_a_of_type_Bjmd);
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_d_of_type_Boolean = false;
        this.jdField_a_of_type_Bjmh.b();
      }
    }
    catch (Exception localException1)
    {
      try
      {
        a();
        do
        {
          return;
          this.jdField_a_of_type_Bjmh.a(10000);
          this.jdField_a_of_type_Bjmh.a();
          break;
          localException1 = localException1;
          if (QLog.isColorLevel()) {
            QLog.e("JBMR2VideoConverterImpl", 1, localException1.getMessage(), localException1);
          }
          this.jdField_a_of_type_Bjmh.a(localException1);
          try
          {
            a();
            return;
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
            this.jdField_a_of_type_Bjmh.a(localException2);
          }
        } while (!QLog.isColorLevel());
        QLog.d("JBMR2VideoConverterImpl", 2, "release Hw Resource error...");
        QLog.d("JBMR2VideoConverterImpl", 2, localException2.getMessage(), localException2);
        return;
      }
      catch (Exception localException3)
      {
        do
        {
          localException3.printStackTrace();
          this.jdField_a_of_type_Bjmh.a(localException3);
        } while (!QLog.isColorLevel());
        QLog.d("JBMR2VideoConverterImpl", 2, "release Hw Resource error...");
        QLog.d("JBMR2VideoConverterImpl", 2, localException3.getMessage(), localException3);
        return;
      }
    }
    finally {}
    try
    {
      a();
      throw localObject;
    }
    catch (Exception localException4)
    {
      for (;;)
      {
        localException4.printStackTrace();
        this.jdField_a_of_type_Bjmh.a(localException4);
        if (QLog.isColorLevel())
        {
          QLog.d("JBMR2VideoConverterImpl", 2, "release Hw Resource error...");
          QLog.d("JBMR2VideoConverterImpl", 2, localException4.getMessage(), localException4);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.util.videoconverter.JBMR2VideoConverterImpl.Converter
 * JD-Core Version:    0.7.0.1
 */