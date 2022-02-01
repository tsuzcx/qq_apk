package com.tencent.mobileqq.shortvideo.util.videoconverter;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.media.MediaMuxer;
import android.view.Surface;
import bdau;
import bdfh;
import bdfi;
import bdfl;
import bdfm;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import log;

class JBMR2VideoConverterImpl$Converter
  implements Runnable
{
  long jdField_a_of_type_Long = -1L;
  MediaExtractor jdField_a_of_type_AndroidMediaMediaExtractor = null;
  MediaMuxer jdField_a_of_type_AndroidMediaMediaMuxer = null;
  bdau jdField_a_of_type_Bdau = null;
  bdfh jdField_a_of_type_Bdfh = null;
  bdfi jdField_a_of_type_Bdfi = null;
  bdfl jdField_a_of_type_Bdfl = null;
  File jdField_a_of_type_JavaIoFile = null;
  boolean jdField_a_of_type_Boolean = true;
  long jdField_b_of_type_Long = -1L;
  MediaExtractor jdField_b_of_type_AndroidMediaMediaExtractor = null;
  bdau jdField_b_of_type_Bdau = null;
  boolean jdField_b_of_type_Boolean = true;
  long jdField_c_of_type_Long = -1L;
  boolean jdField_c_of_type_Boolean = false;
  boolean d;
  
  public JBMR2VideoConverterImpl$Converter(JBMR2VideoConverterImpl paramJBMR2VideoConverterImpl, File paramFile, bdfl parambdfl)
  {
    this.jdField_a_of_type_JavaIoFile = paramFile;
    this.jdField_a_of_type_Bdfl = parambdfl;
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
  
  bdau a(MediaFormat paramMediaFormat, Surface paramSurface)
  {
    Object localObject = bdau.a(paramMediaFormat.getString("mime"), false);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = (MediaCodecInfo)((List)localObject).get(0);
      bdau localbdau = new bdau();
      localbdau.a(paramMediaFormat, ((MediaCodecInfo)localObject).getName(), paramSurface, null);
      localbdau.a();
      return localbdau;
    }
    return null;
  }
  
  bdau a(MediaFormat paramMediaFormat, AtomicReference<Surface> paramAtomicReference)
  {
    bdau localbdau = new bdau();
    localbdau.a(paramMediaFormat, bdau.jdField_a_of_type_Int, null);
    paramAtomicReference.set(localbdau.a().createInputSurface());
    localbdau.a();
    return localbdau;
  }
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("JBMR2VideoConverterImpl", 2, "shutting down encoder, decoder");
    }
    if (this.jdField_a_of_type_Bdfi != null) {
      this.jdField_a_of_type_Bdfi.b();
    }
    if (this.jdField_a_of_type_Bdfh != null) {
      this.jdField_a_of_type_Bdfh.b();
    }
    if (this.jdField_b_of_type_Bdau != null)
    {
      this.jdField_b_of_type_Bdau.c();
      this.jdField_b_of_type_Bdau.d();
    }
    if (this.jdField_a_of_type_Bdau != null)
    {
      this.jdField_a_of_type_Bdau.c();
      this.jdField_a_of_type_Bdau.d();
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
  
  void a(MediaExtractor paramMediaExtractor1, MediaExtractor paramMediaExtractor2, bdau parambdau1, bdau parambdau2, MediaMuxer paramMediaMuxer, bdfh parambdfh, bdfi parambdfi)
  {
    int m = 0;
    int i4 = 0;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(262144);
    long l3 = 0L;
    int i = 0;
    int j = 0;
    MediaFormat localMediaFormat1 = null;
    int k = 0;
    int n = -1;
    long l1 = 0L;
    int i1 = 0;
    MediaFormat localMediaFormat2 = null;
    long l2 = -1L;
    int i3 = -1;
    if (((this.jdField_b_of_type_Boolean) && (i == 0)) || ((this.jdField_a_of_type_Boolean) && (m == 0)))
    {
      this.jdField_d_of_type_Boolean = Thread.interrupted();
      if (this.jdField_d_of_type_Boolean) {
        QLog.e("JBMR2VideoConverterImpl", 1, "doExtractDecodeEditEncodeMux(): isInterrupted");
      }
    }
    else
    {
      return;
    }
    Object localObject;
    label164:
    int i5;
    label197:
    label244:
    long l5;
    if ((this.jdField_a_of_type_Boolean) && (m == 0) && ((localMediaFormat2 == null) || (i4 != 0))) {
      if ((localMediaFormat2 != null) && (i4 != 0))
      {
        localObject = new MediaCodec.BufferInfo();
        ((MediaCodec.BufferInfo)localObject).size = paramMediaExtractor2.readSampleData(localByteBuffer, 0);
        if (((MediaCodec.BufferInfo)localObject).size < 0)
        {
          m = 1;
          if (m != 0) {}
          if ((l3 < l1) && (l1 - l3 > 0L) && (m == 0) && (this.jdField_a_of_type_Boolean)) {
            break label618;
          }
          i5 = 1;
          if ((!this.jdField_b_of_type_Boolean) || (i1 != 0) || ((localMediaFormat1 != null) && (i4 == 0)) || (i5 == 0)) {
            break label1450;
          }
          localObject = parambdau1.a();
          if (localObject == null) {
            break label1450;
          }
          if (((log)localObject).jdField_a_of_type_Int != -1) {
            break label624;
          }
          i2 = k;
          l5 = l2;
          if (!this.jdField_b_of_type_Boolean) {
            break label1429;
          }
          i2 = k;
          l5 = l2;
          if (j != 0) {
            break label1429;
          }
          if (localMediaFormat1 != null)
          {
            i2 = k;
            l5 = l2;
            if (i4 == 0) {
              break label1429;
            }
          }
          i2 = k;
          l5 = l2;
          if (i5 == 0) {
            break label1429;
          }
          localObject = parambdau1.b();
          if (localObject != null) {
            break label904;
          }
          i2 = k;
          k = j;
          j = i2;
          label326:
          if ((!this.jdField_b_of_type_Boolean) || (i != 0) || ((localMediaFormat1 != null) && (i4 == 0)) || (i5 == 0)) {
            break label1426;
          }
          localObject = parambdau2.b();
          if (localObject != null) {
            break label1246;
          }
          label365:
          if ((i4 != 0) || ((this.jdField_a_of_type_Boolean) && (localMediaFormat2 == null)) || ((this.jdField_b_of_type_Boolean) && (localMediaFormat1 == null))) {
            break label1463;
          }
          if (this.jdField_b_of_type_Boolean)
          {
            if (QLog.isColorLevel()) {
              QLog.d("JBMR2VideoConverterImpl", 2, "muxer: adding video track.");
            }
            n = paramMediaMuxer.addTrack(localMediaFormat1);
          }
          if (!this.jdField_a_of_type_Boolean) {
            break label1456;
          }
          if (QLog.isColorLevel()) {
            QLog.d("JBMR2VideoConverterImpl", 2, "muxer: adding audio track.");
          }
          i2 = paramMediaMuxer.addTrack(localMediaFormat2);
          label455:
          if (QLog.isColorLevel()) {
            QLog.d("JBMR2VideoConverterImpl", 2, "muxer: starting");
          }
          paramMediaMuxer.start();
          i4 = 1;
          i3 = i2;
        }
      }
    }
    label664:
    label684:
    label822:
    label1463:
    for (int i2 = i4;; i2 = i4)
    {
      i4 = i2;
      i2 = k;
      k = j;
      j = i2;
      break;
      ((MediaCodec.BufferInfo)localObject).presentationTimeUs = paramMediaExtractor2.getSampleTime();
      ((MediaCodec.BufferInfo)localObject).flags = paramMediaExtractor2.getSampleFlags();
      paramMediaMuxer.writeSampleData(i3, localByteBuffer, (MediaCodec.BufferInfo)localObject);
      if (!paramMediaExtractor2.advance()) {}
      for (i2 = 1;; i2 = 0)
      {
        l4 = ((MediaCodec.BufferInfo)localObject).presentationTimeUs;
        m = i2;
        l3 = l4;
        if (this.jdField_c_of_type_Long <= 0L) {
          break;
        }
        m = i2;
        l3 = l4;
        if (((MediaCodec.BufferInfo)localObject).presentationTimeUs < this.jdField_c_of_type_Long) {
          break;
        }
        m = 1;
        l3 = l4;
        break;
      }
      localMediaFormat2 = paramMediaExtractor2.getTrackFormat(paramMediaExtractor2.getSampleTrackIndex());
      break label164;
      label618:
      i5 = 0;
      break label197;
      label624:
      int i6 = paramMediaExtractor1.readSampleData(((log)localObject).jdField_a_of_type_JavaNioByteBuffer, 0);
      long l4 = paramMediaExtractor1.getSampleTime();
      if (this.jdField_c_of_type_Long > 0L) {
        if (l4 >= this.jdField_c_of_type_Long) {
          i1 = 1;
        }
      }
      for (;;)
      {
        if (i6 >= 0)
        {
          int i7 = ((log)localObject).jdField_a_of_type_Int;
          if (i1 != 0)
          {
            i2 = 4;
            parambdau1.a(i7, i6, l4, i2);
          }
        }
        else
        {
          if (paramMediaExtractor1.advance()) {
            break label822;
          }
        }
        for (i2 = 1;; i2 = 0)
        {
          if (i1 != 0) {
            i2 = 1;
          }
          i1 = i2;
          if (i2 == 0) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("JBMR2VideoConverterImpl", 2, "video extractor: EOS, size = " + i6);
          }
          if (i6 < 0) {
            break label866;
          }
          localObject = parambdau1.a();
          if ((localObject != null) && (((log)localObject).jdField_a_of_type_Int != -1)) {
            break label828;
          }
          i1 = i2;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("JBMR2VideoConverterImpl", 2, "no video decoder input buffer 1");
          i1 = i2;
          break;
          i1 = 0;
          break label664;
          i2 = paramMediaExtractor1.getSampleFlags();
          break label684;
        }
        label828:
        parambdau1.a(((log)localObject).jdField_a_of_type_Int, 0, 0L, 4);
        i1 = i2;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("JBMR2VideoConverterImpl", 2, "videoDecoder.queueInputBuffer, MediaCodec.BUFFER_FLAG_END_OF_STREAM 1 ");
        i1 = i2;
        break;
        label866:
        parambdau1.a(((log)localObject).jdField_a_of_type_Int, 0, 0L, 4);
        i1 = i2;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("JBMR2VideoConverterImpl", 2, "videoDecoder.queueInputBuffer, MediaCodec.BUFFER_FLAG_END_OF_STREAM ");
        i1 = i2;
        break;
        MediaCodec.BufferInfo localBufferInfo = ((log)localObject).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo;
        i6 = ((log)localObject).jdField_a_of_type_Int;
        if (i6 != -1) {
          k = 0;
        }
        if (i6 == -1)
        {
          k += 1;
          i2 = k;
          l5 = l2;
          if (k > 20) {
            throw new Exception("TooManyDecodeTimeOut");
          }
        }
        else
        {
          if (i6 == -3)
          {
            i2 = j;
            j = k;
            k = i2;
            break label326;
          }
          if (i6 == -2)
          {
            parambdau1.a().getOutputFormat();
            i2 = j;
            j = k;
            k = i2;
            break label326;
          }
          if ((localBufferInfo.flags & 0x2) != 0)
          {
            parambdau1.a(((log)localObject).jdField_a_of_type_Int);
            i2 = j;
            j = k;
            k = i2;
            break label326;
          }
          i2 = 0;
          if (this.jdField_c_of_type_Boolean)
          {
            if (localBufferInfo.presentationTimeUs < this.jdField_b_of_type_Long) {
              i2 = 1;
            }
          }
          else {
            if ((localBufferInfo.size == 0) || (i2 != 0)) {
              break label1240;
            }
          }
          float f;
          label1240:
          for (boolean bool = true;; bool = false)
          {
            parambdau1.a().releaseOutputBuffer(i6, bool);
            l4 = l2;
            if (bool)
            {
              parambdfi.c();
              parambdfi.d();
              parambdfh.a(localBufferInfo.presentationTimeUs * 1000L);
              parambdfh.a();
              l4 = l2;
              if (l2 < 0L) {
                l4 = localBufferInfo.presentationTimeUs;
              }
              f = (float)(localBufferInfo.presentationTimeUs - l4) / (float)this.jdField_a_of_type_Long;
              this.jdField_a_of_type_Bdfl.a((int)(f * 10000.0F));
            }
            i2 = k;
            l5 = l4;
            if ((localBufferInfo.flags & 0x4) == 0) {
              break label1429;
            }
            parambdau2.a().signalEndOfInputStream();
            j = k;
            k = 1;
            l2 = l4;
            break;
            i2 = 0;
            break label1077;
          }
          label1246:
          localBufferInfo = ((log)localObject).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo;
          i2 = ((log)localObject).jdField_a_of_type_Int;
          if ((i2 == -1) || (i2 == -3)) {
            break label365;
          }
          if (i2 == -2)
          {
            if (n >= 0) {
              throw new IOException("video encoder changed its output format again?");
            }
            localMediaFormat1 = parambdau2.a().getOutputFormat();
            break label365;
          }
          if ((localBufferInfo.flags & 0x2) != 0)
          {
            parambdau2.a(((log)localObject).jdField_a_of_type_Int);
            break label365;
          }
          if (localBufferInfo.size != 0)
          {
            paramMediaMuxer.writeSampleData(n, ((log)localObject).jdField_a_of_type_JavaNioByteBuffer, localBufferInfo);
            l1 = localBufferInfo.presentationTimeUs;
            f = (float)(localBufferInfo.presentationTimeUs - l2) / (float)this.jdField_a_of_type_Long;
            this.jdField_a_of_type_Bdfl.a((int)(f * 10000.0F));
          }
          if ((localBufferInfo.flags & 0x4) != 0) {
            i = 1;
          }
          parambdau2.a(((log)localObject).jdField_a_of_type_Int);
          break label365;
          break label365;
        }
        k = j;
        j = i2;
        l2 = l5;
        break label326;
        i1 = 0;
      }
      break label244;
      break label164;
      i2 = i3;
      break label455;
    }
  }
  
  protected void a(File paramFile, bdfl parambdfl)
  {
    Object localObject2 = paramFile.getAbsolutePath();
    Object localObject1 = a("video/avc");
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("JBMR2VideoConverterImpl", 2, "Unable to find an appropriate codec for video/avc");
      }
      throw new IOException("Unable to find an appropriate codec for video/avc");
    }
    if (QLog.isColorLevel()) {
      QLog.d("JBMR2VideoConverterImpl", 2, "video found codec: " + ((MediaCodecInfo)localObject1).getName());
    }
    MediaExtractor localMediaExtractor1 = new MediaExtractor();
    localMediaExtractor1.setDataSource((String)localObject2);
    if (b(localMediaExtractor1) < 0) {
      this.jdField_a_of_type_Boolean = false;
    }
    MediaExtractor localMediaExtractor2 = new MediaExtractor();
    localMediaExtractor2.setDataSource((String)localObject2);
    int i = a(localMediaExtractor2);
    if (i < 0) {
      throw new IOException("No video track found in " + paramFile);
    }
    localObject1 = localMediaExtractor2.getTrackFormat(i);
    paramFile = a((MediaFormat)localObject1, (String)localObject2);
    int n = (int)paramFile[2];
    int k = (int)paramFile[0];
    i = (int)paramFile[1];
    this.jdField_a_of_type_Long = paramFile[3];
    bdfm localbdfm = parambdfl.a(k, i);
    if ((localbdfm.jdField_a_of_type_Long >= 0L) && (localbdfm.jdField_b_of_type_Long > 0L) && (localbdfm.jdField_b_of_type_Long - localbdfm.jdField_a_of_type_Long >= 1000L))
    {
      this.jdField_c_of_type_Long = (localbdfm.jdField_b_of_type_Long * 1000L);
      this.jdField_b_of_type_Long = (localbdfm.jdField_a_of_type_Long * 1000L);
      this.jdField_a_of_type_Long = (this.jdField_c_of_type_Long - this.jdField_b_of_type_Long);
      localMediaExtractor2.seekTo(this.jdField_b_of_type_Long, 2);
      localMediaExtractor1.seekTo(this.jdField_b_of_type_Long, 2);
    }
    if (localbdfm.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_Boolean = false;
    }
    if (localbdfm.jdField_d_of_type_Boolean) {
      this.jdField_c_of_type_Boolean = true;
    }
    int j;
    int m;
    if (!localbdfm.jdField_b_of_type_Boolean)
    {
      j = k;
      m = i;
      if (n != 90)
      {
        if (n == 270)
        {
          m = i;
          j = k;
        }
      }
      else
      {
        if (!this.jdField_b_of_type_Boolean) {
          break label709;
        }
        parambdfl = MediaFormat.createVideoFormat("video/avc", Math.round(m * localbdfm.jdField_a_of_type_Float / 16.0F) * 16, Math.round(j * localbdfm.jdField_a_of_type_Float / 16.0F) * 16);
        parambdfl.setInteger("color-format", 2130708361);
        parambdfl.setInteger("bitrate", localbdfm.jdField_a_of_type_Int);
        parambdfl.setFloat("frame-rate", localbdfm.jdField_b_of_type_Int);
        parambdfl.setInteger("i-frame-interval", localbdfm.jdField_c_of_type_Int);
        if (localbdfm.jdField_a_of_type_Boolean)
        {
          parambdfl.setInteger("profile", localbdfm.jdField_d_of_type_Int);
          parambdfl.setInteger("level", localbdfm.e);
        }
        if (localbdfm.f != -1) {
          parambdfl.setInteger("bitrate-mode", localbdfm.f);
        }
        if (QLog.isColorLevel()) {
          QLog.d("JBMR2VideoConverterImpl", 2, "video format: " + parambdfl);
        }
        paramFile = new AtomicReference();
        localObject2 = a(parambdfl, paramFile);
        parambdfl = new bdfh((Surface)paramFile.get());
        parambdfl.c();
        paramFile = new bdfi();
        localObject1 = a((MediaFormat)localObject1, paramFile.a);
      }
    }
    for (;;)
    {
      MediaMuxer localMediaMuxer = new MediaMuxer(localbdfm.jdField_a_of_type_JavaIoFile.getAbsolutePath(), 0);
      if ((this.jdField_b_of_type_Boolean) && (localbdfm.jdField_b_of_type_Boolean)) {
        localMediaMuxer.setOrientationHint(n);
      }
      this.jdField_a_of_type_AndroidMediaMediaExtractor = localMediaExtractor2;
      this.jdField_b_of_type_AndroidMediaMediaExtractor = localMediaExtractor1;
      this.jdField_a_of_type_Bdau = ((bdau)localObject1);
      this.jdField_b_of_type_Bdau = ((bdau)localObject2);
      this.jdField_a_of_type_AndroidMediaMediaMuxer = localMediaMuxer;
      this.jdField_a_of_type_Bdfh = parambdfl;
      this.jdField_a_of_type_Bdfi = paramFile;
      return;
      j = i;
      m = k;
      break;
      label709:
      paramFile = null;
      parambdfl = null;
      localObject1 = null;
      localObject2 = null;
    }
  }
  
  long[] a(MediaFormat paramMediaFormat, String paramString)
  {
    j = paramMediaFormat.getInteger("width");
    k = paramMediaFormat.getInteger("height");
    long l = paramMediaFormat.getLong("durationUs");
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    paramMediaFormat = null;
    try
    {
      localMediaMetadataRetriever.setDataSource(paramString);
      paramString = localMediaMetadataRetriever.extractMetadata(24);
      paramMediaFormat = paramString;
    }
    catch (IllegalArgumentException paramString)
    {
      for (;;)
      {
        int i;
        paramString.printStackTrace();
        continue;
        try
        {
          i = Integer.parseInt(paramMediaFormat);
        }
        catch (NumberFormatException paramString)
        {
          QLog.d("JBMR2VideoConverterImpl", 2, "Video size is " + j + "x" + k + ". rotation: " + paramMediaFormat, paramString);
          i = 0;
        }
      }
    }
    if (paramMediaFormat == null)
    {
      i = 0;
      localMediaMetadataRetriever.release();
      if (QLog.isColorLevel()) {
        QLog.d("JBMR2VideoConverterImpl", 2, "Video size is " + j + "x" + k + ". rotation: " + paramMediaFormat);
      }
      return new long[] { j, k, i, l };
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
      this.jdField_a_of_type_Bdfl.a(0);
      a(this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_Bdfl);
      a(this.jdField_a_of_type_AndroidMediaMediaExtractor, this.jdField_b_of_type_AndroidMediaMediaExtractor, this.jdField_a_of_type_Bdau, this.jdField_b_of_type_Bdau, this.jdField_a_of_type_AndroidMediaMediaMuxer, this.jdField_a_of_type_Bdfh, this.jdField_a_of_type_Bdfi);
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_d_of_type_Boolean = false;
        this.jdField_a_of_type_Bdfl.b();
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
          this.jdField_a_of_type_Bdfl.a(10000);
          this.jdField_a_of_type_Bdfl.a();
          break;
          localException1 = localException1;
          QLog.e("JBMR2VideoConverterImpl", 1, localException1.getMessage(), localException1);
          this.jdField_a_of_type_Bdfl.a(localException1);
          try
          {
            a();
            return;
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
            this.jdField_a_of_type_Bdfl.a(localException2);
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
          this.jdField_a_of_type_Bdfl.a(localException3);
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
        this.jdField_a_of_type_Bdfl.a(localException4);
        if (QLog.isColorLevel())
        {
          QLog.d("JBMR2VideoConverterImpl", 2, "release Hw Resource error...");
          QLog.d("JBMR2VideoConverterImpl", 2, localException4.getMessage(), localException4);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.videoconverter.JBMR2VideoConverterImpl.Converter
 * JD-Core Version:    0.7.0.1
 */