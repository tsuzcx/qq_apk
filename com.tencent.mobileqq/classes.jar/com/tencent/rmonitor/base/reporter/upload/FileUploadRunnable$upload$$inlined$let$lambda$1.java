package com.tencent.rmonitor.base.reporter.upload;

import java.io.File;
import java.net.HttpURLConnection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke", "com/tencent/rmonitor/base/reporter/upload/FileUploadRunnable$upload$1$3"}, k=3, mv={1, 1, 15})
final class FileUploadRunnable$upload$$inlined$let$lambda$1
  extends Lambda
  implements Function0<Unit>
{
  FileUploadRunnable$upload$$inlined$let$lambda$1(FileUploadRunnable paramFileUploadRunnable, File paramFile, HttpURLConnection paramHttpURLConnection)
  {
    super(0);
  }
  
  public final void invoke()
  {
    if (this.$uploadFile$inlined.isFile()) {
      this.$uploadFile$inlined.delete();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.reporter.upload.FileUploadRunnable.upload..inlined.let.lambda.1
 * JD-Core Version:    0.7.0.1
 */