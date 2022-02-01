package okio;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"isAndroidGetsocknameError", "", "Ljava/lang/AssertionError;", "Lkotlin/AssertionError;", "(Ljava/lang/AssertionError;)Z", "appendingSink", "Lokio/Sink;", "Ljava/io/File;", "sink", "append", "Ljava/io/OutputStream;", "Ljava/net/Socket;", "Ljava/nio/file/Path;", "options", "", "Ljava/nio/file/OpenOption;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Sink;", "source", "Lokio/Source;", "Ljava/io/InputStream;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Source;", "okio"}, k=5, mv={1, 1, 16}, xs="okio/Okio")
final class Okio__JvmOkioKt
{
  @NotNull
  public static final Sink appendingSink(@NotNull File arg0) {}
  
  public static final boolean isAndroidGetsocknameError(@NotNull AssertionError arg0) {}
  
  @JvmOverloads
  @NotNull
  public static final Sink sink(@NotNull File arg0) {}
  
  @JvmOverloads
  @NotNull
  public static final Sink sink(@NotNull File arg0, boolean arg1) {}
  
  @NotNull
  public static final Sink sink(@NotNull OutputStream arg0) {}
  
  @NotNull
  public static final Sink sink(@NotNull Socket arg0) {}
  
  @IgnoreJRERequirement
  @NotNull
  public static final Sink sink(@NotNull Path arg0, @NotNull OpenOption... arg1) {}
  
  @NotNull
  public static final Source source(@NotNull File arg0) {}
  
  @NotNull
  public static final Source source(@NotNull InputStream arg0) {}
  
  @NotNull
  public static final Source source(@NotNull Socket arg0) {}
  
  @IgnoreJRERequirement
  @NotNull
  public static final Source source(@NotNull Path arg0, @NotNull OpenOption... arg1) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.Okio__JvmOkioKt
 * JD-Core Version:    0.7.0.1
 */